package com.kael.datastructure.set;

import java.util.HashSet;
import java.util.Set;

public class Test1 {
    public static void main(String[] args) {
        Set<String> strings = new HashSet<>();
        for (int i=0; i<15; i++) {
            strings.add(i+"");
        }

        for (String i : strings) {
            System.out.print(i + "\t");
        }
        System.out.println("");
    }
}
