package com.sframe.component.common.config;

import com.sframe.component.common.interceptor.RequestLogInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.Resource;

/**
 * @author mumu
 * @vervion v1.0
 * @description 拦截器配置类
 * @date 2017/7/8 2017, 下午11:41
 */
@Configuration
@EnableAsync
public class WebAppConfiguration extends WebMvcConfigurerAdapter {

    @Resource
    private RequestLogInterceptor requestLogInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(requestLogInterceptor).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

}
