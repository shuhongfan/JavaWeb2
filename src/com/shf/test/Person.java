package com.shf.test;

import java.util.Arrays;

public class Person {
    private String id;
    private int age;
    private String name;
    private String gender;
    private String[] hobby;

    public Person() {
    }

    public Person(String id, int age, String name, String gender, String[] hobby) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.gender = gender;
        this.hobby = hobby;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String[] getHobby() {
        return hobby;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "Person{" +
                "学号id=" + id +
                ", 年龄age=" + age +
                ", 姓名name='" + name + '\'' +
                ", 性别gender='" + gender + '\'' +
                ", 兴趣爱好hobby=" + Arrays.toString(hobby) +
                '}';
    }
}
