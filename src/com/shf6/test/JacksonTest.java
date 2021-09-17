package com.shf6.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shf6.domain.Person;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class JacksonTest {
//    java转换为json
    @Test
    public void test1() throws IOException {
        Person p=new Person();
        p.setName("张三");
        p.setAge(23);
        p.setGender("男");

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(p);
        System.out.println(json);

//        写数据到文件中
        mapper.writeValue(new File("a.txt"),p);

        mapper.writeValue(new FileWriter("b.txt"),p);
    }

    @Test
    public void test2() throws IOException {
        Person p=new Person();
        p.setName("张三");
        p.setAge(23);
        p.setGender("男");
        p.setBirthday(new Date());

//       转换
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(p);
        System.out.println(s);
    }

    @Test
    public void test3() throws IOException {
        Person p1=new Person();
        p1.setName("张三");
        p1.setAge(23);
        p1.setGender("男");
        p1.setBirthday(new Date());

        Person p2=new Person();
        p2.setName("张三");
        p2.setAge(23);
        p2.setGender("男");
        p2.setBirthday(new Date());

        Person p3=new Person();
        p3.setName("张三");
        p3.setAge(23);
        p3.setGender("男");
        p3.setBirthday(new Date());

        ArrayList<Person> person = new ArrayList<>();
        person.add(p1);
        person.add(p2);
        person.add(p3);

//       转换
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(person);
        System.out.println(s);
    }


    @Test
    public void test4() throws IOException {
        HashMap<String, Object> map = new HashMap<>();
       map.put("name","张三");
       map.put("age",23);
       map.put("gender","男");

//       转换
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(map);
        System.out.println(s);
    }

    @Test
    public void test5() throws IOException {
        String json="{\"gender\":\"男\",\"name\":\"张三\",\"age\":23}";
//        创建ObjectMapper对象
        ObjectMapper mapper = new ObjectMapper();
//        转换为java对象
        Person person = mapper.readValue(json, Person.class);
        System.out.println(person);
    }
}
