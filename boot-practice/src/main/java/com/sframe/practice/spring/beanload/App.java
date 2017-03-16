package com.sframe.practice.spring.beanload;

import com.sframe.practice.spring.beanload.bean.*;
import com.sframe.practice.spring.beanload.mvc.User;
import com.sframe.practice.spring.beanload.mvc.UserController;
import com.sframe.practice.spring.beanload.mvc.UserDao;
import com.sframe.practice.spring.beanload.mvc.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author mumu
 * @vervion v1.0
 * @description
 * @date 2017/2/11 2017, 下午1:17
 */
public class App {

    public static void main(String[] args) {
        System.out.println("hello spring 4!");

        // 读取 spring 容器中的 bean
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class, User.class, UserDao.class, UserService.class, UserController.class);
        System.out.println(context.getBean(MyBean.class));
        System.out.println(context.getBean("myBean"));

        System.out.println(context.getBean(Jeep.class));
        System.out.println(context.getBean("createRunnableFactoryBean"));
        System.out.println(context.getBean("&createRunnableFactoryBean"));
        System.out.println(context.getBean(RunnableFactoryBean.class));

        System.out.println(context.getBean(Car.class));
        System.out.println(context.getBean("createCar"));

        System.out.println(context.getBean(Cat.class));
        System.out.println(context.getBean("createCat"));
        System.out.println(context.getBean(Dog.class));
        System.out.println(context.getBean("createDog"));
        System.out.println(context.getBean(Animal.class));
        System.out.println(context.getBean("createAnimal"));

        // AnnotationConfigApplicationContext 直接装载 使用注解注入的 user bean
        System.out.println(context.getBean("user"));
        System.out.println(context.getBean(UserDao.class));
        System.out.println(context.getBean(UserService.class));
        System.out.println(context.getBean(UserController.class));
        context.getBean(UserController.class).show();

        context.close();
    }
}
