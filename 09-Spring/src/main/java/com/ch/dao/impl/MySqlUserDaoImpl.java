package com.ch.dao.impl;

import com.ch.dao.IUserDao;
import com.ch.domain.User;
import org.springframework.stereotype.Repository;

@Repository("MySqlUserDao")
public class MySqlUserDaoImpl implements IUserDao {

    @Override
    public void insertUser(User user) {
        System.out.println("MySqlUserDaoImpl insertUser");
    }
}
