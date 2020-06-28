package com.kael.datastructure.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Test1 {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        for (int i=0; i<10; i++) {
            queue.add(i+"");
        }
        System.out.println("剔除第一个元素："+queue.poll());
        System.out.println("获取第一个元素:"+queue.element());
        System.out.println("获取第一个元素:"+queue.peek());
        while (!queue.isEmpty()) {
            // 全部删除
            queue.poll();
        }
        System.out.println(queue.peek());
    }
}
