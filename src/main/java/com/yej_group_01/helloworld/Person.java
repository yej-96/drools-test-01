package com.yej_group_01.helloworld;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * Date:  2020/05/26
 * Time:  16:56
 * User: yej
 * Person 类 对应 Drools 里面的fact
 */
public class Person implements Serializable {
    static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private int age;

    public Person() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
