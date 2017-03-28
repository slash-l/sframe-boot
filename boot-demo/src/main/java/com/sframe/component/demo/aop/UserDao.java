package com.sframe.component.demo.aop;

import org.springframework.stereotype.Component;

/**
 * @author mumu
 * @vervion v1.0
 * @description
 * @date 2017/3/27 2017, 下午11:37
 */
@Component
public class UserDao implements IUserDao{

    public void add(String username, String password){
        System.out.println("add [username: "+username+", password: " + password + "]");
    }

}
