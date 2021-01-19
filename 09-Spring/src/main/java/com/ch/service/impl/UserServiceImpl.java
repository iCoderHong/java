package com.ch.service.impl;

import com.ch.dao.IUserDao;
import com.ch.domain.User;
import com.ch.service.IUserService;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserServiceImpl implements IUserService {

    private IUserDao userDao;

    public UserServiceImpl() { }

    public UserServiceImpl(IUserDao userDao) {
        this.userDao = userDao;
    }

    public IUserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void saveUser(User user) {
        userDao.insertUser(user);
    }
}
