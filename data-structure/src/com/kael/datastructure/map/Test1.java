package com.kael.datastructure.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Test1 {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("1","java");
        map.put("2","python");
        map.put("3","go");
        map.put("4","c++");
        map.put("5","c");
        //one(map);
        //two(map);
        three(map);
    }

    public static void one(Map<String,String> map) {
        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String,String> entry : entries) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }

    public static void two(Map<String,String> map) {
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> next = iterator.next();
            System.out.println(next.getKey()+":"+next.getValue());
            iterator.remove();
        }
        System.out.println(map.size());
    }

    public static void three(Map<String,String> map) {
        Set<String> strings = map.keySet();
        for (String s : strings) {
            System.out.println(s+":"+map.get(s));
        }
    }
}
