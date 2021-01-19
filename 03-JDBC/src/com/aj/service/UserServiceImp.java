package com.aj.service;

import com.aj.dao.UserDao;
import com.aj.dao.imp.UserDaoImp;
import com.aj.doman.PageBean;
import com.aj.doman.User;

import java.util.List;

public class UserServiceImp implements UserService {

    public User findUser(String name, String password) {
        UserDao userDao = new UserDaoImp();
        return userDao.findUser(name, password);
    }

    public User findUser(String id) {
        UserDao userDao = new UserDaoImp();
        return userDao.findUser(id);
    }

    public PageBean<User> findUser(Integer currPage, Integer pageSize) {
        PageBean<User> pageBean = new PageBean<>();
        pageBean.setCurrPage(currPage);
        pageBean.setPageSize(pageSize);

        UserDao userDao = new UserDaoImp();
        List<User> list = userDao.findUser(currPage, pageSize);
        pageBean.setList(list);

        Integer count = userDao.findUserCount();
        pageBean.setTotalCount(count);
        return pageBean;
    }

    @Override
    public boolean deleteUser(String[] uids) {
        // TODO:事件回滚
        UserDao userDao = new UserDaoImp();
        for (String uid : uids) {
            userDao.deleteUser(uid);
        }
        return true;
    }

    public List<User> findAll() {
        UserDao userDao = new UserDaoImp();
        return userDao.findAll();
    }

    public boolean addUser(User user) {
        UserDao userDao = new UserDaoImp();
        return userDao.addUser(user);
    }

    public boolean deleteUser(String id) {
        UserDao userDao = new UserDaoImp();
        return userDao.deleteUser(id);
    }

    public boolean updateUser(User user) {
        UserDao userDao = new UserDaoImp();
        return userDao.updateUser(user);
    }
}
