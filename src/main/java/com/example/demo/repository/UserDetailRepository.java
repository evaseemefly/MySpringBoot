package com.example.demo.repository;

import com.example.demo.model.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author:evaseemeflye
 * @Date:Created in 21:02 2019/10/9
 */

public interface UserDetailRepository extends JpaSpecificationExecutor<UserDetail>,JpaRepository<UserDetail, Long>{
}
