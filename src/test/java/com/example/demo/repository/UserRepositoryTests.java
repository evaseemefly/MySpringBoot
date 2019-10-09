package com.example.demo.repository;

import com.example.demo.model.User;
//import com.example.demo.repository.UserRepository;
import com.example.demo.repository.UserRepository;
import net.bytebuddy.TypeCache;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author:evaseemeflye
 * @Date:Created in 20:13 2019/10/8
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {
    @Resource
    private UserRepository userRepository;

    @Test
    public void test() {

        Date date = new Date();

        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formattedDate = dateFormat.format(date);

//        new User()

        System.out.print("准备开始写入");
        userRepository.save(new User("aa", "aa@126.com", "aa", "aa123456", formattedDate));
//        userRepository.save(new User("bb","bb@126.com","bb","bb123456",formattedDate));
//        userRepository.save(new User("cc","cc@126.com","cc","cc123456",formattedDate));

        System.out.print("写入成功");
//        Assert.assertEquals(9,userRepository.findAll().size());
//        Assert.assertEquals("bb",userRepository.findByUserNameOrEmail("bb","cc@126.com").getNickName());
//        userRepository.delete(userRepository.findByUserName("aa1"));
    }

    @Test
    public void testFind() {
        List<User> list= userRepository.findAll();
        User temp =userRepository.findByUserNameOrEmail("","cc");

//        Assert.assertEquals(9, userRepository.findAll().size());

//        Assert.assertEquals("bb",userRepository.findByUserNameOrEmail("bb","cc@126.com").getNickName());
//        userRepository.delete(userRepository.findByUserName("aa1"));
    }

    @Test
    public void testPageQuery(){
        int page=1,size=2;
        Sort sort=new Sort(Sort.Direction.DESC,"id");

        Pageable pageable= PageRequest.of(page,size,sort);
        Page<User> list2= userRepository.findByNickName("cc123456",pageable);

        Page<User> list= userRepository.findAllBy(pageable);
    }
}
