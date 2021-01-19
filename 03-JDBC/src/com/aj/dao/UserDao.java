package com.aj.dao;

import com.aj.doman.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();

    User findUser(String id);

    boolean deleteUser(String id);

    User findUser(String name, String password);

    boolean addUser(User user);

    boolean updateUser(User user);

    List<User> findUser(Integer currPage, Integer pageSize);

    Integer findUserCount();
}
