package com.aj.demo;

import com.aj.doman.Product;
import com.aj.utils.JDBCPoolUtil;
import jdk.nashorn.internal.ir.debug.PrintVisitor;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import sun.rmi.runtime.Log;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class JDBCTemplate {
    @Test
    public void test() {
        // Spring框架对JDBC的简单封装 提供了一个JDBCTemplate对象简化JDBC的开发
        DataSource dataSource = JDBCPoolUtil.getDataSource();
        JdbcTemplate template = new JdbcTemplate(dataSource);
        // 使用template完成CRUD的操作
        String sql = "UPDATE user SET address = ? WHERE id = ?;";
        int rows = template.update(sql, "上海", 2);
        System.out.println(rows);
    }
    @Test
    public void test2() {
        // Spring框架对JDBC的简单封装 提供了一个JDBCTemplate对象简化JDBC的开发
        DataSource dataSource = JDBCPoolUtil.getDataSource();
        JdbcTemplate template = new JdbcTemplate(dataSource);
        // 使用template完成CRUD的操作

        String sql = "INSERT INTO product VALUES (NULL, ?, ?, ?);";
        int rows = template.update(sql, "iPhone 11 proMax", "apple", 7888);

        System.out.println(rows);
    }

    @Test
    public void test3() {
        // Spring框架对JDBC的简单封装 提供了一个JDBCTemplate对象简化JDBC的开发
        DataSource dataSource = JDBCPoolUtil.getDataSource();
        JdbcTemplate template = new JdbcTemplate(dataSource);

        String sql = "SELECT * FROM product where pid = ?";
        Map<String, Object> map = template.queryForMap(sql, 1);
        System.out.println(map);

        // template.queryForMap查询的结果集只能是1条数据 并将结果数据封装map
    }

    @Test
    public void test4() {
        // Spring框架对JDBC的简单封装 提供了一个JDBCTemplate对象简化JDBC的开发
        DataSource dataSource = JDBCPoolUtil.getDataSource();
        JdbcTemplate template = new JdbcTemplate(dataSource);

        String sql = "SELECT * FROM product LIMIT ?, ?";
        List<Map<String, Object>> maps = template.queryForList(sql, 0, 2);
        System.out.println(maps);

        // 将一行数据封装为map 再将封装的map放入一个list结合中
    }

    @Test
    public void test5() {
        // Spring框架对JDBC的简单封装 提供了一个JDBCTemplate对象简化JDBC的开发
        DataSource dataSource = JDBCPoolUtil.getDataSource();
        JdbcTemplate template = new JdbcTemplate(dataSource);

        String sql = "SELECT * FROM product;";
        List<Product> products = template.query(sql, new RowMapper<Product>() {
            @Override
            public Product mapRow(ResultSet resultSet, int i) throws SQLException {
                Product product = new Product();
                product.setPid(resultSet.getInt("pid"));
                product.setPname(resultSet.getString("pname"));
                product.setBrand(resultSet.getString("brand"));
                product.setPrice(resultSet.getDouble("price"));
                resultSet.getInt("pid");
                return product;
            }
        });

        // template.queryForObject()
    }

    @Test
    public void test6() {
        // Spring框架对JDBC的简单封装 提供了一个JDBCTemplate对象简化JDBC的开发
//        DataSource dataSource = JDBCPoolUtil.getDataSource();
//        JdbcTemplate template = new JdbcTemplate(dataSource);
//
//        String sql = "SELECT * FROM product;";
//
//        List<Product> products = template.query(sql, new Product());
//        System.out.println(products);

        // template.queryForObject()
    }

    @Test
    public void test7() {
        // Spring框架对JDBC的简单封装 提供了一个JDBCTemplate对象简化JDBC的开发
        DataSource dataSource = JDBCPoolUtil.getDataSource();
        JdbcTemplate template = new JdbcTemplate(dataSource);

        String sql = "SELECT * FROM product;";

        List<Product> products = template.query(sql, new BeanPropertyRowMapper<Product>(Product.class));
        products.forEach((element)->{
            System.out.println(element);
        });

        // Bean的基本数据类型 一定使用对应的包装类型 否则表中字段数据为NULL 查询结果的null对bean的属性基本类型赋值报错
    }

    @Test
    public void test8() {
        // Spring框架对JDBC的简单封装 提供了一个JDBCTemplate对象简化JDBC的开发
        DataSource dataSource = JDBCPoolUtil.getDataSource();
        JdbcTemplate template = new JdbcTemplate(dataSource);
        String sql = "SELECT count(*) FROM product;";
        Long count = template.queryForObject(sql, long.class);
        System.out.println(count);

        // queryForObject一般用户聚合函数查询
    }
}
