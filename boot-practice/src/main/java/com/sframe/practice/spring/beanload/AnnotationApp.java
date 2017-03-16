package com.sframe.practice.spring.beanload;

import com.sframe.practice.spring.beanload.bean.MyBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author mumu
 * @vervion v1.0
 * @description
 * @date 2017/2/13 2017, 下午10:42
 */
public class AnnotationApp {

    public static void main(String[] args) {
        //使用扫描的方式加载 bean
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.sframe.practice.spring.beanload");
        System.out.println(context.getBean(MyBean.class));
        System.out.println(context.getBean("myBean"));
        context.close();
    }
}
