package com.sframe.practice.spring.extend;

import com.sframe.practice.spring.extend.bean.Book;
import com.sframe.practice.spring.extend.bean.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author mumu
 * @vervion v1.0
 * @description 在 javaBean 中获取 applicationContext（参考 User Book）
 * @date 2017/2/15 2017, 下午10:11
 */
public class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.sframe.practice.spring.extend");
        context.getBean(User.class).show();
//        System.out.println(context.getBean(User.class));
        context.getBean(Book.class).show();
        context.close();
    }
}
