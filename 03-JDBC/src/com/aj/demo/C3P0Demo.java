package com.aj.demo;


import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class C3P0Demo {
    public static void main(String[] args) throws SQLException {
        // 创建连接池对象ComboPooledDataSource
        DataSource dataSource = new ComboPooledDataSource();
        // 获取连接
        Connection connection = dataSource.getConnection();

        connection.close();
    }
}
