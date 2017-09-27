package com.sframe;

import com.sframe.component.demo.aop.IUserDao;
import com.sframe.component.demo.event.MyApplicationEvent;
import com.sframe.component.demo.init.MyApplicationContextInitializer;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * 
 * @ClassName: Application 
 * @Description: spring boot demo 启动类
 * @author mumu
 *
 * @date 2016年7月23日 下午4:15:34 
 * @version V1.0
 */
@Slf4j
@ServletComponentScan //配置Druid的监控页面需要用到的注解
@MapperScan("com.sframe.**.dao")
@SpringBootApplication
public class DemoApplication extends SpringBootServletInitializer {

    /**
     * 用于 war 部署配置
     * @param application
     * @return
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DemoApplication.class);
    }

	public static void main(String[] args) {
        SpringApplication app = new SpringApplication(DemoApplication.class);
        ConfigurableApplicationContext context = app.run(args);

        // 打印获取 spring 容器中所有 bean 名称
//		logger.info("Let's inspect the beans provided by Spring Boot:");
//        String[] beanNames = context.getBeanDefinitionNames();
//        Arrays.sort(beanNames);
//        for (String beanName : beanNames) {
//        	logger.info(beanName);
//        }

        /**
         * ApplicationContextInitializer 接口是在 spring 容器执行 refreshed 之前的一个回调
         * 参考 demo.init 包
         * 步骤：
         * 1 写一个类，实现 ApplicationContextInitializer 接口
         * 2 注册 ApplicationContextInitializer
         *
         * 注册方法：
         * 1 SpringApplication.addInitializers
         * 2 通过配置项 context.initializer.classes 配置项指定，可以指定多个，用逗号隔开
         *
         * CommandLineRunner 在 spring 容器启动后最后一个回调
         * 步骤：
         * 1 写一个类，实现 CommandLineRunner
         * 2 把该类纳入到 spring 容器管理中
         * 注意：可以通过 @Order 注解控制执行的顺序
         */
        app.addInitializers(new MyApplicationContextInitializer());

        //事件监听
        //参考 demo.event 包
        context.publishEvent(new MyApplicationEvent(new Object()));

        //aop 测试
        log.info(context.getBean(IUserDao.class).getClass().toString());
        context.getBean(IUserDao.class).add("admin", "123");

        log.info("============= SpringBoot Start Success =============");
    }

}
