package org.example.levelcache;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class CacheBlock {

    int level;
    private IndividualCache cache;
    private CacheBlock nextCache;

    public CacheBlock(int level, int capacity, EvictionPolicy evictionPolicy, CacheBlock nextCache){
        this.level = level;
        this.cache = new IndividualCache(capacity, evictionPolicy);
        this.nextCache = nextCache;
    }

    public Pair<String, Integer> get(String key) {
        Pair<String, Integer> res;
        String val = cache.get(key);
        if(val.isEmpty()){
            if(nextCache != null) {
                res = nextCache.get(key);
            }
            else{
                res = new Pair<>("", -1);
            }
        }
        else{
            res = new Pair<>(val, level);
        }
        return res;
    }

    public void put(String key, String value){
        Pair<String, String> node = cache.put(key, value);
        if(!node.getValue().isEmpty() && nextCache != null) {
            nextCache.put(node.getKey(), node.getValue());
        }
    }

    public void delete(String key) {
        cache.delete(key);
        if(nextCache!= null) {
            nextCache.delete(key);
        }
    }
}
