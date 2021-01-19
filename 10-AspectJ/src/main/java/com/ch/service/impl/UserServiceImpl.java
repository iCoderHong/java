package com.ch.service.impl;

import com.ch.service.IUserService;

public class UserServiceImpl implements IUserService {
    @Override
    public void deleteById(String id) {
        System.out.println("======= UserServiceImpl deleteById "+ id +" ========");
    }

    @Override
    public int updateById(String id) {
        System.out.println("======= UserServiceImpl updateById "+ id +" ========");
        return 1;
    }
}
