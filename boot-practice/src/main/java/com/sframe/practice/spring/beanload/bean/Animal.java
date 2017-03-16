package com.sframe.practice.spring.beanload.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author mumu
 * @vervion v1.0
 * @description
 * @date 2017/2/11 2017, 下午10:42
 */
public class Animal {

    @PostConstruct
    public void initial(){
        System.out.println("--------- animal init ----------");
    }

    @PreDestroy
    public void close(){
        System.out.println("--------- animal destroy ----------");
    }
}
