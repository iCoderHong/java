package com.ch.test;

import com.ch.domain.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class JacksonTest {

    @Test
    public void test1() throws Exception {
        // Jsonlib Gson fastjson jackson(spring 内置)
        Person person = new Person();
        person.setName("jack");
        person.setAge(12);
        person.setGender("男");
        person.setBirthday(new Date());

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(person);
        System.out.println(json);

        ArrayList<Person> list = new ArrayList<>();
        list.add(person);
        list.add(person);
        list.add(person);
        System.out.println(objectMapper.writeValueAsString(list));

        // objectMapper.writeValue(new File("/Users/coderhong/Desktop/1.txt"), list);

        // Writer writer = new FileWriter(new File("/Users/coderhong/Desktop/1.txt"));
        // objectMapper.writeValue(writer, list);
    }

    @Test
    public void test2() throws JsonProcessingException {
        // json字符串转Java对象
        ObjectMapper objectMapper = new ObjectMapper();
        String json = "{\"name\":\"jack\",\"age\":12,\"birthday\":\"2020-12-31\"}";
        Person person = objectMapper.readValue(json, Person.class);
    }
}
