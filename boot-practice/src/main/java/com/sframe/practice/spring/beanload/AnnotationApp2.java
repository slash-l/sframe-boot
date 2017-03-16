package com.sframe.practice.spring.beanload;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author mumu
 * @vervion v1.0
 * @description
 * @date 2017/2/13 2017, 下午10:48
 */
public class AnnotationApp2 {

    public static void main(String[] args) {
        //使用扫描的方式加载 bean
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AnnotionScan.class);

        //AnnotationScan 类中排除了 UserController 的扫描，所以下面加载会报错
//        System.out.println(context.getBean(UserController.class));
        System.out.println(context.getBean("myBean"));
        context.close();
    }
}
