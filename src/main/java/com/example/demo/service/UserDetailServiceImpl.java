package com.example.demo.service;

//import antlr.StringUtils;

import com.mysql.cj.util.StringUtils;
import com.example.demo.model.UserDetail;
import com.example.demo.param.UserDetailParam;
import com.example.demo.repository.UserDetailRepository;
import com.example.demo.service.UserDetailService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
//import java.util.function.Predicate;
import javax.annotation.Resource;
import javax.persistence.criteria.Predicate;

/**
 * @Author:evaseemeflye
 * @Date:Created in 21:08 2019/10/9
 */
public class UserDetailServiceImpl implements UserDetailService {
    @Resource
    private UserDetailRepository userDetailRepository;


    @Override
    public Page<UserDetail> findByCondition(UserDetailParam detailParam, Pageable pageable) {

        return userDetailRepository.findAll(
                (root, query, cb) -> {
                    List<Predicate> predicates = new ArrayList<Predicate>();
//            StringUtils
                    //equal 示例
                    if (!StringUtils.isNullOrEmpty(detailParam.getIntroduction())) {
                        predicates.add(cb.equal(root.get("introduction"), detailParam.getIntroduction()));
                    }
                    //like 示例
                    if (!StringUtils.isNullOrEmpty(detailParam.getRealName())) {
                        predicates.add(cb.like(root.get("realName"), "%" + detailParam.getRealName() + "%"));
                    }
                    //between 示例
                    if (detailParam.getMinAge() != null && detailParam.getMaxAge() != null) {
                        Predicate agePredicate = cb.between(root.get("age"), detailParam.getMinAge(), detailParam.getMaxAge());
                        predicates.add(agePredicate);
                    }
                    //greaterThan 大于等于示例
                    if (detailParam.getMinAge() != null) {
                        predicates.add(cb.greaterThan(root.get("age"), detailParam.getMinAge()));
                    }
                    return query.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
                },
                pageable);

    }

}
