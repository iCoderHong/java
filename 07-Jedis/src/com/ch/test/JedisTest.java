package com.ch.test;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.*;

public class JedisTest {

    @Test
    public void test1() {
        // 获取连接
        Jedis jedis = new Jedis("localhost", 6379);
        jedis.set("name", "jack");
        jedis.close();
    }

    @Test
    public void test2() {
        // 获取连接
        Jedis jedis = new Jedis("localhost", 6379);
         HashMap<String, String> map = new HashMap<>();
        jedis.hset("user", "name", "jack");
        jedis.hset("user", "age", "12");
        jedis.hset("user", "height", "1.89");

        String name = jedis.hget("user", "name");
        System.out.println(name);

        Map<String, String> user = jedis.hgetAll("user");
        user.forEach((key, value) -> {
            System.out.println("key=" + key + " value=" + value);
        });

        jedis.close();
    }

    @Test
    public void test3() {
        Jedis jedis = new Jedis("localhost", 6379);

        // 清空
        jedis.del("names");

        jedis.lpush("names", "Jack", "Rose", "Jim");
        jedis.rpush("names", "A", "B", "C");

        // 弹出
        String e1 = jedis.lpop("names");
        String e2 = jedis.rpop("names");

        List<String> names = jedis.lrange("names", 0, -1);
        System.out.println(names);

        jedis.close();
    }

    @Test
    public void test4() {
        Jedis jedis = new Jedis("localhost", 6379);

        jedis.del("dev");

        jedis.sadd("dev", "ios", "java", "html");
        Set<String> devSet = jedis.smembers("dev");
        System.out.println(devSet);

        jedis.close();
    }
}

/**
 * 集合回顾
 HashSet<String> set = new HashSet<>();
 LinkedHashSet<String> linkSet = new LinkedHashSet<>();

 HashMap<String, String> map = new HashMap<>();
 LinkedHashMap<String, String> linkMap = new LinkedHashMap<>();
 */