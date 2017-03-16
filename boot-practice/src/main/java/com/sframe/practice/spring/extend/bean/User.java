package com.sframe.practice.spring.extend.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author mumu
 * @vervion v1.0
 * @description
 * @date 2017/2/15 2017, 下午10:09
 */
@Component
public class User {

    @Autowired
    private ApplicationContext applicationContext;

    public void init(){
        System.out.println("user init");
    }

    public void show(){
        System.out.println("user:" + applicationContext);
    }

}
