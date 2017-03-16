package com.sframe.practice.spring.extend.bean;

import org.springframework.stereotype.Component;
import sun.rmi.runtime.Log;

/**
 * @author mumu
 * @vervion v1.0
 * @description
 * @date 2017/2/16 2017, 下午10:37
 */
public class LogUser extends User{

    public void show(){
        System.out.println("log user start...");
        super.show();
        System.out.println("log user end...");
    }
}
