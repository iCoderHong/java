package com.aj.demo;

import com.aj.utils.JDBCUtil;

import java.sql.*;
import java.util.ResourceBundle;

public class JDBCDemo {
    public static void main(String[] args) throws SQLException, ClassNotFoundException   {
        // Connection connection = JDBCUtils.getConnection();
        method1();
    }

    /**
     * 基本的JDBC
     */
    private static void method1() {
        Connection connection = null;
        Statement statement = null;
        try {
            // 注册驱动
            // java.sql.Driver driver = new com.mysql.jdbc.Driver();
            // DriverManager.registerDriver(driver);
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 获取连接
            String url = "jdbc:mysql://127.0.0.1:3306/test?characterEncoding=utf-8";
            String user = "root";
            String password = "762100";
            connection = DriverManager.getConnection(url, user, password);
            // 获取数据库操作对象(Statement专门执行sql语句)
            statement = connection.createStatement();
            // 执行SQL语句
            // String mysql = "CREATE TABLE USER (uid INT PRIMARY KEY AUTO_INCREMENT, username VARCHAR(20) DEFAULT NULL);";
            // String mysql = "INSERT INTO USER values (NULL, 'Jack', "123456");"
            String mysql = "UPDATE USER SET address = '百事可乐' WHERE id = 2;";
            // String mysql = "ALTER TABLE user ADD password varchar(32) NOT NULL;";
            // 专门执行DML语句 (insert delete update) 返回影响的记录条数
            int count = statement.executeUpdate(mysql);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 配置方式
     */
    private static void method2() {
        Connection connection = null;
        Statement statement = null;
        try {
            ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
            String dirver = bundle.getString("driver");
            String url = bundle.getString("url");
            String user = bundle.getString("user");
            String password = bundle.getString("password");
            // 注册驱动
            Class.forName(dirver);
            // 获取连接
            connection = DriverManager.getConnection(url, user, password);

            // 获取数据库操作对象(Statement专门执行sql语句)
            statement = connection.createStatement();

            // 执行SQL语句
            // String mysql = "CREATE TABLE USER (uid INT PRIMARY KEY AUTO_INCREMENT, username VARCHAR(20) DEFAULT NULL);";
            // String mysql = "INSERT INTO U
            String mysql = "INSERT into user VALUES(NULL, 'jack', '123', 1);";
            // 专门执行DML语句 (insert delete update) 返回影响的记录条数
            int count = statement.executeUpdate(mysql);
            System.out.println(count);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(connection, statement);
        }
    }

    /**
     * 查询结果集
     */
    private static void method3() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
            String dirver = bundle.getString("driver");
            String url = bundle.getString("url");
            String user = bundle.getString("user");
            String password = bundle.getString("password");
            // 注册驱动
            Class.forName(dirver);
            // 获取连接
            connection = DriverManager.getConnection(url, user, password);

            // 获取数据库操作对象(Statement专门执行sql语句)
            statement = connection.createStatement();

            // 执行SQL语句
            String mysql = "SELECT *FROM USER;";
            resultSet = statement.executeQuery(mysql);
            System.out.println("=======================");
            while (resultSet.next()) {
                int uid = resultSet.getInt("uid");
                String username = resultSet.getString("username");
                System.out.println(uid + "  " + username);
            }
            System.out.println("=======================");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(connection, statement, resultSet);
        }
    }

    /**
     * 抽取工具类
     */
    private static void method4() {
        Connection connection = null;
        Statement statement = null;
        try {
            // 获取连接
            connection = JDBCUtil.getConnection();
            // 获取数据库操作对象(Statement专门执行sql语句)
            statement = connection.createStatement();
            // 执行SQL语句
            // String mysql = "CREATE TABLE USER (uid INT PRIMARY KEY AUTO_INCREMENT, username VARCHAR(20) DEFAULT NULL);";
             String mysql = "INSERT into user VALUES(NULL, 'jack', '123', 1);";
            // String mysql = "UPDATE USER SET username = 'Jack' WHERE uid = 1;";
            // 专门执行DML语句 (insert delete update) 返回影响的记录条数
            int count = statement.executeUpdate(mysql);
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(connection, statement);
        }
    }
}