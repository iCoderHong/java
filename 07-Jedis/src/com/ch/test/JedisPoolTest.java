package com.ch.test;

import com.ch.utils.JedisUtil;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolTest {
    @Test
    public void test1() {

        // 自定义配置
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(50);
        config.setMaxIdle(10);
        // 初始化带自定义配置
        // JedisPool jedisPool = new JedisPool(config, "localhost", 6379);

        JedisPool jedisPool = new JedisPool("localhost", 6379);
        Jedis jedis = jedisPool.getResource();

        // jedis操作.....

        jedis.close(); // 关闭(将jedis归还到jedisPool)
    }

    @Test
    public void test2() {
        Jedis jedis = JedisUtil.getJedis();
        jedis.set("alis", "哈哈");
        System.out.println(jedis.get("alis"));
        jedis.close();
    }
}
