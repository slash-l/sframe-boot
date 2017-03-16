package com.sframe.practice.spring.beanload.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author mumu
 * @vervion v1.0
 * @description 通过实现 FactoryBean 也可以将 Bean 注入到容器中
 * @date 2017/2/11 2017, 下午5:16
 */
public class RunnableFactoryBean implements FactoryBean<Jeep>{

    public Jeep getObject() throws Exception {
        return new Jeep();
    }

    public Class<?> getObjectType() {
        return Jeep.class;
    }

    public boolean isSingleton() {
        return true;
    }
}
