package com.sframe.demo.test.dao;

import com.sframe.component.demo.test.bean.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author mumu
 * @vervion v1.0
 * @description
 * @date 2017/4/2 2017, 下午3:47
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes=TestBeanConfiguration.class)
public class ApplicationContextTest {

    @Autowired
    private ApplicationContext context;

    @Test
    public void testNull(){
        Assert.assertNotNull(context.getBean(User.class));
        Assert.assertNotNull(context.getBean(Runnable.class));
    }

}
