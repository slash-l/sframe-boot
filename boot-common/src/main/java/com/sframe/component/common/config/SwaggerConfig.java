package com.sframe.component.common.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * @author mumu
 * @vervion v1.0
 * @description
 * @date 2017/7/23 2017, 下午7:11
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket sframeApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("sframe").apiInfo(sframeApiInfo())
//                .genericModelSubstitutes(DeferredResult.class)
//                .useDefaultResponseMessages(false)
//                .forCodeGeneration(true)
//                .pathMapping("/")// base，最终调用接口后会和paths拼接在一起
                .select()
                .paths(Predicates.or(
                        PathSelectors.regex("/v1"),
                        PathSelectors.regex("/v1/.*")))//过滤的接口
                .build();
    }

    private ApiInfo sframeApiInfo() {
        ApiInfo apiInfo = new ApiInfo("sweet house api",//大标题
                "sweet house api",//小标题
                "1.0",//版本
                "NO terms of service",
                "mumu",//作者
                "",//链接显示文字
                ""//网站链接
        );
        return apiInfo;
    }

}
