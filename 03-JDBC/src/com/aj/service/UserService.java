package com.aj.service;

import com.aj.doman.PageBean;
import com.aj.doman.User;

import java.util.List;

public interface UserService {

    boolean addUser(User user);

    boolean deleteUser(String id);

    boolean updateUser(User user);

    List<User> findAll();

    PageBean<User> findUser(Integer currPage, Integer pageSize);

    User findUser(String name, String password);

    User findUser(String id);

    boolean deleteUser(String[] uids);
}
