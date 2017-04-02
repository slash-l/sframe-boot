package com.sframe.demo.test.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author mumu
 * @vervion v1.0
 * @description
 *
 * TestRestTemplate 需要运行在web环境中
 * @SpringBootTest 会加载整个spring容器
 *
 * @date 2017/4/2 2017, 下午4:18
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testHome() {
        String content = restTemplate.getForObject("/book/home", String.class);
        Assert.assertEquals("bookhome", content);
    }

    @Test
    public void testShow() {
        String content = restTemplate.getForObject("/book/show?id=100", String.class);
        Assert.assertEquals("book100", content);
    }

}
