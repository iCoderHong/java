package com.ch.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtil {
    private static SqlSessionFactory sessionFactory;
    private static ThreadLocal<SqlSession> local = new ThreadLocal<>();

    private MyBatisUtil() { }

    static {
        try {
            InputStream inputstream = Resources.getResourceAsStream("mybatis_config.xml");
            sessionFactory = new SqlSessionFactoryBuilder().build(inputstream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getCurrentSqlSession() {
        return getCurrentSqlSession(false);
    }

    public static SqlSession getCurrentSqlSession(boolean autoCommit) {
        SqlSession session = local.get();
        if (session == null) {
            session = sessionFactory.openSession(autoCommit);
            local.set(session);
        }
        return session;
    }

    public static void close(SqlSession session) {
        if (session != null) {
            session.close();
            // 非常重要 Tomcat自带线程池
            local.remove();
        }
    }

    public static void rollback(SqlSession session) {
        if (session != null) {
            session.rollback();
        }
    }
}
