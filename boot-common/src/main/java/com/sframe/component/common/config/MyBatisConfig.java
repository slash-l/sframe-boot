package com.sframe.component.common.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import com.github.pagehelper.PageHelper;

/**
 * 
 * @ClassName: MyBatisConfig 
 * @Description: mybatis 配置 
 * @author mumu
 * @date 2016年7月23日 下午6:57:37 
 * @version V1.0
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
@MapperScan("com.sframe.component.**.dao")
public class MyBatisConfig {

    @Autowired
    DataSource dataSource;
 
    //提供SqlSeesion
    @Bean
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
 
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
 
        //分页插件
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        /**
         * 3.3.0版本可用 - 分页参数合理化，默认false禁用
         * 启用合理化时，如果pageNum<1会查询第一页，如果pageNum>pages会查询最后一页
         * 禁用合理化时，如果pageNum<1或pageNum>pages会返回空数据
         */
        properties.setProperty("reasonable", "true");


        properties.setProperty("supportMethodsArguments", "true");
        properties.setProperty("returnPageInfo", "check");
        properties.setProperty("params", "count=countSql");


        pageHelper.setProperties(properties);

        //添加插件
        sqlSessionFactoryBean.setPlugins(new Interceptor[]{pageHelper});
        
        //添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
        	sqlSessionFactoryBean.setMapperLocations(resolver.getResources("com/**/dao/*.xml"));
            return sqlSessionFactoryBean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
 
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }
    
}
