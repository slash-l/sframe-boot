package com.sframe.component.demo.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author mumu
 * @vervion v1.0
 * @description
 * @date 2017/3/27 2017, 下午11:37
 */
@Component
@Slf4j
public class UserDao implements IUserDao{

    public void add(String username, String password){
        log.info("add [username: "+username+", password: " + password + "]");
    }

}
