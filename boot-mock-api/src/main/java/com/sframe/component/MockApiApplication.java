package com.sframe.component;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * @author mumu
 * @vervion v1.0
 * @description
 * @date 2017/6/25 2017, 下午9:22
 */
@Slf4j
@SpringBootApplication
public class MockApiApplication extends SpringBootServletInitializer {

    /**
     * 用于 war 部署配置
     * @param application
     * @return
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MockApiApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(MockApiApplication.class, args);
        log.info("============= Mock Api Start Success =============");
    }

}
