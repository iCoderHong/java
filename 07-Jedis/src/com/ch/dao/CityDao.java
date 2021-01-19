package com.ch.dao;

import com.ch.domain.City;
import com.ch.utils.JDBCPoolUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CityDao {

    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCPoolUtil.getDataSource());

    public List<City> findAllCity() {
        String sql = "select * from city";
        List<City> citys = jdbcTemplate.query(sql, new BeanPropertyRowMapper<City>(City.class));
        return citys;
    }
}
