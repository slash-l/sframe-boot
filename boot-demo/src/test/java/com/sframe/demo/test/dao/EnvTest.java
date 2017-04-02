package com.sframe.demo.test.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.EnvironmentTestUtils;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author mumu
 * @vervion v1.0
 * @description
 *
 * springboot会优先加载测试环境下的配置文件（application.properties）
 * 测试环境下没有才会加载正式环境下的配置文件
 *
 * @date 2017/4/2 2017, 下午4:08
 */
@RunWith(SpringRunner.class)
@SpringBootTest(properties={"app.version=1.0.0"})
public class EnvTest {

    @Autowired
    private ConfigurableEnvironment env;

    @Before
    public void init(){
        EnvironmentTestUtils.addEnvironment(env, "app.admin.name=admin");
        EnvironmentTestUtils.addEnvironment(env, "app.admin.enable=true");
    }

    @Test
    public void testValue(){
        Assert.assertEquals("spring boot", env.getProperty("app.name"));
        Assert.assertEquals("1.0.0", env.getProperty("app.version"));
        Assert.assertEquals("admin", env.getProperty("app.admin.name"));
        Assert.assertEquals("true", env.getProperty("app.admin.enable"));
    }

}
