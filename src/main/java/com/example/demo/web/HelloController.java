package com.example.demo.web;

import com.example.demo.model.User;
import org.springframework.web.bind.annotation.*;

//import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


import javax.annotation.Resource;


// 引入mapper
import com.example.demo.mapper.UserMapper;


@RestController
public class HelloController {

    @Resource
    private UserMapper userMapper;
    /**
    * @Author:evaseemefly
    * @Description:
    * @Date:15:21 2019/9/28 
    */
    @RequestMapping("/hello")
    public String hello(String name) {
        /**
        * @Author:evaseemefly
        * @Description:
        * @param: * @param name 姓名
        * @Date:15:25 2019/9/28 
        */
        return  "hello world,"+name;
    }

//    @RequestMapping(name="/getuser",method = RequestMethod.GET)
    @GetMapping("/getuser")
    public User getUser(){
        /**
        * @Author:evaseemefly
        * @Description: 获取user
        * @param: * @param
        * @Date:15:28 2019/9/28 
        */
        User user=new User();
//        user.setName("小明");
//        user.setAge(19);
//        user.setPass("123456");
        return user;
    }

//    @RequestMapping(name="/getuserlist")
    @GetMapping("/getuserlist")
    public List<User> getUsers(){
//        List<User> users=new ArrayList<User>();
//        User user1=new User();
//        user1.setName("neo");
//        user1.setAge(30);
//        user1.setPass("neo123");
//        users.add(user1);
//        User user2=new User();
//        user2.setName("小明");
//        user2.setAge(12);
//        user2.setPass("123456");
//        users.add(user2);

        // v2 改为从数据库中读取
        List<User> users=userMapper.getAll();
        return users;
    }

    @GetMapping("/targetuser")
    public User getTargetUser(User user){
        /**
        * @Author:evaseemefly
        * @Description: 传入的参数为指定的User对象，会将符合user中定义的属性的参数一一映射
        * @param: * @param user
        * @Date:16:05 2019/9/28 
        */
        return user;
    }

    @GetMapping(value="get/{name}")
    public String get(@PathVariable String name){
        /**
        * @Author:evaseemefly
        * @Description: 使用url进行传参，而不再使用param的方式（即?params=xx）的方式
        * @param: * @param name
        * @Date:16:07 2019/9/28 
        */
        return name;
    }
}
