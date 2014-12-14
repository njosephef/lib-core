package com.pnv.hash;

import java.util.Collection;
import java.util.Iterator;
import java.util.SortedMap;
import java.util.TreeMap;


/**
 * 
 *
 * @author ngvtien
 * @version $Revision:  $
 */
public class ConsistentHashRouter
{
    private static final SortedMap<Long, VirtualNode> RING = new TreeMap<Long, VirtualNode>();
    
    private MD5Hash hashfunction = new MD5Hash();


    public ConsistentHashRouter(Collection<Node> nodes, int vNodeCount)
    {
        for (Node node : nodes)
        {
            addNode(node, vNodeCount);
        }
    }


    public void addNode(Node node, int vnodeCount)
    {
        int existingReplicas = getReplicas(node.toString());
        for (int i = 0; i < vnodeCount; i++)
        {
            VirtualNode vNode = new VirtualNode(node, i + existingReplicas);
            RING.put(hashfunction.hash(vNode.toString()), vNode);
        }
    }


    public void removeNode(Node node)
    {
        Iterator<Long> it = RING.keySet().iterator();
        while (it.hasNext())
        {
            Long key = it.next();
            VirtualNode virtualNode = RING.get(key);
            if (virtualNode.matches(node.toString()))
            {
                it.remove();
            }
        }
    }


    public Node getNode(String key)
    {
        if (RING.isEmpty())
        {
            return null;
        }
        Long hashKey = hashfunction.hash(key);
        SortedMap<Long, VirtualNode> tailMap = RING.tailMap(hashKey);
        hashKey = tailMap != null && !tailMap.isEmpty() ? tailMap.firstKey() : RING.firstKey();
        return RING.get(hashKey).getParent();
    }


    public int getReplicas(String nodeName)
    {
        int replicas = 0;
        for (VirtualNode vNode : RING.values())
        {
            if (vNode.matches(nodeName))
            {
                replicas++;
            }
        }
        return replicas;
    }


	public int size() {
		return RING.size();
	}
}