package com.sframe.practice.spring.beanload;

import com.sframe.practice.spring.beanload.bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author mumu
 * @vervion v1.0
 * @description 将 bean 装配到 spring 的容器中
 * @date 2017/2/11 2017, 下午4:40
 */
@Configuration
public class Config {

    //直接装载 spring 中的 MyBean
    @Bean(name = "myBean")
    @Scope("prototype")
    public MyBean createBean(){
        return new MyBean();
    }

    //通过实现 spring 的 FactoryBean 接口的工厂类 RunnableFactoryBean 装载 spring 中的类
    @Bean
    public RunnableFactoryBean createRunnableFactoryBean(){
        return new RunnableFactoryBean();
    }

    //通过自定义的工厂类装载 spring 中的类
    @Bean
    public CarFactory createCarFactory(){
        return new CarFactory();
    }

    @Bean
    public Car createCar(CarFactory factory){
        return factory.create();
    }

    // 装载 bean 前和后可设置执行的方法
    // 1 参考 Cat
    // 2 参考 Dog
    // 3 参考 Animal
    @Bean
    public Cat createCat(){
        return new Cat();
    }

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Dog createDog(){
        return new Dog();
    }

    @Bean
    public Animal createAnimal(){
        return new Animal();
    }
}
