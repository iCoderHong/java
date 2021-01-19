package com.ch.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JedisUtil {

    private static JedisPool jedisPool;

    public JedisUtil() { }

    static {
        try {
            // 加载Jedis配置
            ClassLoader classLoader = JedisUtil.class.getClassLoader();
            InputStream is = classLoader.getResourceAsStream("jedis.properties");
            Properties properties = new Properties();
            properties.load(is);

            int port = Integer.parseInt(properties.getProperty("port"));
            String url = properties.getProperty("host");
            int maxTotal = Integer.parseInt(properties.getProperty("maxTotal"));
            int maxIdle = Integer.parseInt(properties.getProperty("maxIdle"));

            // 创建Jedis配置对象
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(maxTotal);
            config.setMaxIdle(maxIdle);

            // 创建JedisPool对象
            jedisPool = new JedisPool(config, url, port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Jedis getJedis() {
        Jedis jedis = jedisPool.getResource();
        return jedis;
    }

    public static void close(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }
}
