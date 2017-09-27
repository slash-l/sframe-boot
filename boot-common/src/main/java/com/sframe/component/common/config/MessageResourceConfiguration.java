package com.sframe.component.common.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * @author mumu
 * @vervion v1.0
 * @description
 * @date 2017/7/21 2017, 上午12:14
 */
@Configuration
public class MessageResourceConfiguration {

    private static String PROPERTY_POSTFIX = ".properties";

    private PathMatchingResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver();

    @Bean
    public MessageSource messageSource() throws IOException {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setBasenames(baseNames());

        return messageSource;
    }

    /**
     * 动态获取文言配置
     * @return 国际化配置文件
     */
    private String[] baseNames() throws IOException {
        Resource[] resources = patternResolver.getResources("messages/*.properties");
        Set<String> sets = new HashSet<>();
        for(Resource resource: resources){
            String name = resource.getFilename().substring(0,resource.getFilename().indexOf(PROPERTY_POSTFIX));
            if(name.indexOf('_')>0){
                name = name.substring(0,name.lastIndexOf('_'));
            }
            sets.add(name);
        }

        return sets.stream().map(t -> "messages/"+t).toArray(String[]::new);

    }

}
