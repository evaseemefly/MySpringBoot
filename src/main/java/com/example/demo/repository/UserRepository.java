package com.example.demo.repository;

import com.example.demo.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @Author:evaseemeflye
 * @Date:Created in 20:09 2019/10/8
 */
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUserName(String userName);

    User findByUserNameOrEmail(String username,String email);

    @Query("select u from User u")
    Page<User> findAllBy(Pageable pageable);

//    @Query("select u from user u where u.nickName = :nickName")
//    Page<User> findByNickName(@Param("nickName") String nickName, Pageable pageable);

    @Query("select u from User u where u.nickName = :nickName")
    Page<User> findByNickName(@Param("nickName") String nickName, Pageable pageable);
}
