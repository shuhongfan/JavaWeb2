package com.shf.test;

public class Hello {
    public static void main(String[] args) {
        Person person = new Person();
        person.setId("0213217522");
        person.setAge(21);
        person.setName("舒洪凡");
        person.setGender("男");
        person.setHobby(new String[]{"计算机","羽毛球","运动"});
        System.out.println(person);
    }
}
