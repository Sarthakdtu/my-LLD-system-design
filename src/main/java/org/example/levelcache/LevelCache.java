package org.example.levelcache;

import javafx.util.Pair;

import java.util.LinkedList;

public class LevelCache {

    int numLevels;
    private int capacity;

    private LinkedList<CacheBlock> caches;


    public LevelCache(int capacity, int numLevels, EvictionPolicy evictionPolicy) {
        this.capacity = capacity;
        this.numLevels = numLevels;
        this.caches = new LinkedList<>();
        CacheBlock nextCacheBlock = null;
        for(int i=0;i<capacity;i++){
            nextCacheBlock = new CacheBlock(this.capacity - i, capacity, evictionPolicy, nextCacheBlock);
            caches.addFirst(nextCacheBlock);
        }
    }

    public String get(String key) {
        Pair<String, Integer> res = caches.getFirst().get(key);
        if(res.getValue() == -1){
            return "";
        }
        else if(res.getValue() != 1){
            caches.getFirst().put(key, res.getKey());
        }
        return res.getKey();
    }

    public void put(String key, String value) {
        caches.getFirst().put(key, value);
    }

    public void delete(String key) {
        caches.getFirst().delete(key);
    }

}
