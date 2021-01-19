package com.aj.demo;

import com.aj.utils.JDBCPoolUtil;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.support.spring.stat.annotation.Stat;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DruidDemo {
    public static void main(String[] args) throws Exception {
//        1.durid连接池基本使用
//        Properties properties = new Properties();
//        ClassLoader classLoader = DruidDemo.class.getClassLoader();
//        InputStream inputStream = classLoader.getResourceAsStream("druid.properties");
//        properties.load(inputStream);
//
//        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
//        Connection connection = dataSource.getConnection();
//        connection.close();

        // durid连接池工具类
//        Connection connection = JDBCPoolUtil.getConnection();
//        System.out.println(connection);
//        JDBCPoolUtil.close(connection, null);

        JDBCPoolUtilTest();
    }

    private static void JDBCPoolUtilTest() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCPoolUtil.getConnection();
            String sql = "SELECT DEPTNO, JOB, COUNT(*) FROM emp GROUP BY DEPTNO, JOB ORDER BY DEPTNO;";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();

            System.out.println("====================");
            while (resultSet.next()) {
                Integer DEPTNO = resultSet.getInt("DEPTNO");
                String JOB = resultSet.getString("JOB");
                String COUNT = resultSet.getString("COUNT(*)");
                System.out.println(DEPTNO + " " + JOB + " " + COUNT);
            }
            System.out.println("====================");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCPoolUtil.close(connection, statement, resultSet);
        }
    }
}
