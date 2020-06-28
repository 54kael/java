package com.kael.datastructure.set;

import com.kael.datastructure.entity.User;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Test2 {
    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        User u1 = new User().age(18).id(1).name("长门");
        User u2 = new User().age(19).id(2).name("小南");
        User u3 = new User().age(20).id(3).name("绝");
        User u4 = new User().age(18).name("长门").id(1);
        Set<User> userSet = new HashSet<>();
        userSet.add(u1);
        userSet.add(u2);
        userSet.add(u3);
        userSet.add(u4);

        for (User user:userSet) {
            System.out.println(user);
        }

    }
}
