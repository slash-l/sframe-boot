package com.sframe.practice.spring.beanload.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author mumu
 * @vervion v1.0
 * @description
 * @date 2017/2/11 2017, 下午10:27
 */
public class Cat implements InitializingBean, DisposableBean {

    public void afterPropertiesSet() throws Exception{
        System.out.println("-------- cat bean 装载前初始化方法执行 -------");
    }

    public void destroy() throws Exception {
        System.out.println("-------- cat destroy --------");
    }
}
