package com.example.demo.mapper;

import com.example.demo.model.User;

import java.util.List;

/**
 * @Author:evaseemeflye
 * @Date:Created in 17:51 2019/9/28
 */
public interface UserMapper_bak {
    List<User> getAll();

//    List<User> getList(UserParam userParam);
//
//    int getCount(UserParam userParam);

    User getOne(Long id);

    void insert(User user);

    int update(User user);

    int delete(Long id);
}
