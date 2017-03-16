package com.sframe.component.demo.init;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author mumu
 * @vervion v1.0
 * @description
 * @date 2017/3/6 2017, 下午10:50
 */
public class MyApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        System.out.println("bean count: " + configurableApplicationContext.getBeanDefinitionCount());
    }

}
