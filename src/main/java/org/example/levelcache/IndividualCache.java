package org.example.levelcache;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class IndividualCache {

    private int capacity;
    private EvictionPolicy evictionPolicy;

    private LinkedList<Pair<String, String>> list;

    private Map<String, Pair<String, String>> map;

    public IndividualCache(int capacity, EvictionPolicy evictionPolicy){
        this.capacity = capacity;
        this.evictionPolicy = evictionPolicy;
        this.list = new LinkedList<>();
        map = new HashMap<>();
    }

    public int getSize() {
        return list.size();
    }

    private Pair<String, String> use(String key, String value) {
        switch(evictionPolicy) {
            case LRU: {
                useLRU(key, value);
                break;
            }
            case LFU: {
                useLFU(key, value);
                break;
            }
            default: {
                break;
            }
        }
        return null;
    }

    private Pair<String, String> useLRU(String key, String value) {
        return null;
    }

    private Pair<String, String> useLFU(String key, String value) {
        return null;
    }


    public String get(String key) {
        String val = "";
        if(map.containsKey(key)){
            val = map.get(key).getValue();
            use(key, val);
        }
        return val;
    }

    public Pair<String, String> put(String key, String value){
        return use(key, value);
    }

    public void delete(String key) {
        if(map.containsKey(key)){
            Pair<String, String> node = map.get(key);
            list.remove(node);
            map.remove(key);
        }
    }
}
