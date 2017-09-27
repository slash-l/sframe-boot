package com.sframe.component.common.config;

import com.google.common.base.Predicates;
import com.google.common.collect.Lists;
import com.sframe.component.common.base.constant.ResponseOutvoCode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

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
                .build()
                .globalResponseMessage(RequestMethod.GET, commonResponseMessage())
                .globalResponseMessage(RequestMethod.POST, commonResponseMessage())
                .globalResponseMessage(RequestMethod.PUT, commonResponseMessage())
                .globalResponseMessage(RequestMethod.DELETE, commonResponseMessage())
                .globalResponseMessage(RequestMethod.PATCH, commonResponseMessage());
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

    private List<ResponseMessage> commonResponseMessage(){
        return Lists.newArrayList(
                new ResponseMessageBuilder().code(HttpStatus.OK.value()).message("成功")
                        .responseModel(new ModelRef(ResponseOutvoCode.SUCCESS.name())).build(),
                new ResponseMessageBuilder().code(HttpStatus.BAD_REQUEST.value()).message("参数错误")
                        .responseModel(new ModelRef("参数错误")).build(),
                new ResponseMessageBuilder().code(HttpStatus.INTERNAL_SERVER_ERROR.value()).message("系统错误")
                        .responseModel(new ModelRef(ResponseOutvoCode.SYSTEM_ERROR.name())).build()
        );
    }

}
