package com.sframe.practice.spring.beanload;

import com.sframe.practice.spring.beanload.mvc.UserController;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * @author mumu
 * @vervion v1.0
 * @description
 * @date 2017/2/13 2017, 下午10:49
 */
@ComponentScan(basePackages = "com.sframe.spring.beanload",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = UserController.class))
@Configuration
public class AnnotionScan {
}
