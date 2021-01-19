package com.ch.service;

import com.ch.dao.CityDao;
import com.ch.domain.City;
import com.ch.utils.JedisUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import redis.clients.jedis.Jedis;

import java.util.List;

public class CityService {

    public List<City> findAllCity() {
        CityDao cityDao = new CityDao();
        return cityDao.findAllCity();
    }

    public String findAllCityJSON() {
        // 1.先从Redis中获取
        Jedis jedis = JedisUtil.getJedis();
        String cityList = jedis.get("cityList");
        if (cityList == null) {
            // Redis没有缓存 MySQL数据库中获取
            try {
                System.out.println("========= 从数据库中查询城市信息 =========");
                List<City> list = this.findAllCity();
                ObjectMapper objectMapper = new ObjectMapper();
                String json = objectMapper.writeValueAsString(list);
                // 将获取的结果缓存Redis
                jedis.set("cityList", json);
                System.out.println("========= 城市信息缓存Redis =========");
                return json;
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        } else  {
            System.out.println("========= 从Redis中获取城市信息 =========");
            return cityList;
        }
    }
}
