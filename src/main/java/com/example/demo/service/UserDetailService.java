package com.example.demo.service;

import com.example.demo.model.UserDetail;
import com.example.demo.param.UserDetailParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @Author:evaseemeflye
 * @Date:Created in 21:04 2019/10/9
 */
public interface UserDetailService {

    Page<UserDetail> findByCondition(UserDetailParam detailParam, Pageable pageable);
}
