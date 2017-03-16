package com.sframe.component.demo.interceptor;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author mumu
 * @vervion v1.0
 * @description
 * @date 2017/3/12 2017, 下午10:29
 */
@SpringBootConfiguration
public class WebConfiguration extends WebMvcConfigurerAdapter {

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogHandlerInterceptor());
    }
}
