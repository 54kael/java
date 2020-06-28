package com.kael.datastructure.entity;

public class User {
    private Integer id;
    private String name;
    private Integer age;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public User id(int id){
        this.id = id;
        return this;
    }

    public User age(int age) {
        this.age = age;
        return this;
    }

    public User name(String name){
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj==null) {
            return false;
        }
        if (this==obj) {
            return true;
        }
        if (obj instanceof User) {
            User u = (User) obj;
            return this.name.equals(u.name) && this.id.equals(u.id) && this.age.equals(u.age);
        } else {
            return false;
        }
    }

    /**
     * 作用是获取哈希码，实际上就是整数，这个哈希码的作用是确定该对象在哈希表中的索引位置。
     * 对象是否相等的依据是先判断hashCode是否相等，如果相等，再判断equals方法。这样就大大减少equals比较
     * @return
     */
    @Override
    public int hashCode() {
        return this.id;
    }
}
