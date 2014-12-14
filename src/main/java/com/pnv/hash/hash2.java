package com.pnv.hash;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class hash2 {
    private TreeMap<Long, Object> nodes = new TreeMap<Long, Object>();
    private List<Object> shards = new ArrayList<Object>();
    private int VIRTUAL_NUM = 4;

    MD5Hash md5Hash = new MD5Hash();

    public void init() {
        shards.add("192.168.0.0-s0");
        shards.add("192.168.0.1-s1");
//		shards.add("192.168.0.2-s2");
//		shards.add("192.168.0.3-s3");
//		shards.add("192.168.0.4-s4");


        for (int i = 0; i < shards.size(); i++) {
            Object shardInfo = shards.get(i);
            for (int j = 0; j < VIRTUAL_NUM; j++) {
                nodes.put(md5Hash.hash("SHARD-" + i + "-NODE-" + j),
                        shardInfo);
            }
        }
    }

    public Object getShardInfo(long hash) {
        Long key = hash;
        SortedMap<Long, Object> tailMap = nodes.tailMap(key);
        if (tailMap.isEmpty()) {
            key = nodes.firstKey();
        } else {
            key = tailMap.firstKey();
        }
        return nodes.get(key);
    }

    public void printMap() {
        System.out.println(nodes);
    }


    public static void main(String[] args) {
        MD5Hash md5Hash = new MD5Hash();
        hash2 h = new hash2();
        h.init();
        h.printMap();
        for (int i = 0; i < 50; i++) {
            System.out.println(h.getShardInfo(md5Hash.hash(String.valueOf(i))));
        }
    }
}