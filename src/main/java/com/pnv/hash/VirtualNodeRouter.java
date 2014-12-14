package com.pnv.hash;

import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class VirtualNodeRouter {
	
    interface HashCalculator {
        long calculateHash(String key);
    }
 
    private static class VirtualNode {
        final String nodeName;
        final int replicaNumber;
 
        VirtualNode(final String nodeName, final int replicaNumber) {
            this.nodeName = nodeName.toLowerCase();
            this.replicaNumber = replicaNumber;
        }
 
        boolean matches(String host) {
            return nodeName.equalsIgnoreCase(host);
        }
 
        @Override
        public String toString() {
            return nodeName + ":" + replicaNumber;
        }
    }
 
    private final HashCalculator hashFunction;
    private final SortedMap<Long, VirtualNode> virtualNodePoolByHash = new TreeMap<Long, VirtualNode>(
            new Comparator<Long>() {
                public int compare(Long i, Long j) {
                    if (i > j) {
                        return 1;
                    } else if (i < j) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            });
 
    public VirtualNodeRouter() {
        this(new HashCalculator() {
            public long calculateHash(String key) {
                try {
                    MessageDigest sha1 = MessageDigest.getInstance("SHA1");
                    sha1.update(key.getBytes());
                    byte[] digest = sha1.digest();
                    return bytesToLong(digest);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
 
    public VirtualNodeRouter(final HashCalculator f) {
        this.hashFunction = f;
    }
 
    /**
     * Adds a node with one replica
     *
     * @param node
     *            - node name
     */
    public void add(String node) {
        add(node, 1);
    }
 
    /**
     * Adds a node to the available pool
     *
     * @param node
     *            - node name
     * @param replicas
     *            - # of replicas - increase # of replicas based on the
     *            computing power of the machine
     */
    public void add(String node, int replicas) {
        // Note: You can call this method incrementally by adding more replicas,
        // so that you don't cause DOS on
        // your own services
        int existingReplicas = getReplicas(node);
 
        for (int i = 0; i < replicas; i++) {
            VirtualNode virtualNode = new VirtualNode(node, i
                    + existingReplicas);
            virtualNodePoolByHash.put(hashFunction.calculateHash(virtualNode
                    .toString()), virtualNode);
        }
    }
 
    /**
     * remove the node from available pool
     *
     * @param node
     */
    public void remove(String node) {
        Iterator<Long> it = virtualNodePoolByHash.keySet().iterator();
        while (it.hasNext()) {
            Long key = it.next();
            VirtualNode virtualNode = virtualNodePoolByHash.get(key);
            if (virtualNode.matches(node)) {
                it.remove();
            }
        }
    }
 
    public String getNode(String key) {
        if (virtualNodePoolByHash.isEmpty()) {
            return null;
        }
        long hash = hashFunction.calculateHash(key);
        for (Map.Entry<Long, VirtualNode> e : virtualNodePoolByHash.entrySet()) {
            if (hash < e.getKey()) {
                return e.getValue().nodeName;
            }
        }
        SortedMap<Long, VirtualNode> tailMap = virtualNodePoolByHash
                .tailMap(hash);
        hash = tailMap.isEmpty() ? virtualNodePoolByHash.firstKey() : tailMap
                .firstKey();
        return virtualNodePoolByHash.get(hash).nodeName;
    }
 
    public void dump() {
        for (Map.Entry<Long, VirtualNode> e : virtualNodePoolByHash.entrySet()) {
            System.out.println("  " + e.getKey() + " => " + e.getValue());
        }
    }
 
    public int getReplicas(String nodeName) {
        int replicas = 0;
        for (VirtualNode node : virtualNodePoolByHash.values()) {
            if (node.matches(nodeName)) {
                replicas++;
            }
        }
        return replicas;
    }
 
    private static long bytesToLong(byte[] b) {
        ByteBuffer bb = ByteBuffer.wrap(b);
        return bb.getLong();
    }
}