package com.sframe.practice.spring.beanload.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;

/**
 * @author mumu
 * @vervion v1.0
 * @description
 * @date 2017/2/11 2017, 下午10:55
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ApplicationContext applicationContext;

    public void show(){
        userService.show();
        System.out.println("applicationContext:" + applicationContext);
    }
}
