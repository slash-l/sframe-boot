package com.sframe.demo.test.dao;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * @author mumu
 * @vervion v1.0
 * @description
 * @date 2017/4/2 2017, 下午3:49
 */
@TestConfiguration
public class TestBeanConfiguration {

    @Bean
    public Runnable createRunnable(){
        return () -> {};
    }
}
