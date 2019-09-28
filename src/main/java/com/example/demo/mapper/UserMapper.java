package com.example.demo.mapper;
import java.util.List;
import com.example.demo.model.User;
import com.example.demo.enums.UserSexEnum;
/**
 * @Author:evaseemeflye
 * @Date:Created in 17:51 2019/9/28
 */
public interface UserMapper {
    List<User> getAll();

//    List<User> getList(UserParam userParam);
//
//    int getCount(UserParam userParam);

    User getOne(Long id);

    void insert(User user);

    int update(User user);

    int delete(Long id);
}
