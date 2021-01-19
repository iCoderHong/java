package com.aj.utils;

import java.lang.invoke.ConstantCallSite;
import java.sql.*;
import java.util.ResourceBundle;

public class JDBCUtil {
    private static String DRIVER;
    private static String URL;
    private static String USER;
    private static String PASSWORD;

    // 工具类的方法一般是静态的 不需要实例化
    private JDBCUtil() {}

    // 静态代码块在类加载是执行 并且只执行一次(调用类方法是会触发static代码块执行)
    static  {
        try {
            ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
            DRIVER = bundle.getString("driver");
            URL = bundle.getString("url");
            USER = bundle.getString("user");
            PASSWORD = bundle.getString("password");
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    /**
     * 关闭连接 释放资源
     * @param connection
     * @param statement
     */
    public static void close(Connection connection, Statement statement) {
        close(connection, statement, null);
    }

    public static void close(Connection connection, Statement statement, ResultSet resultSet) { // 注意:释放顺序
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
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
