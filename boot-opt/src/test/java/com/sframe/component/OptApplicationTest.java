package com.sframe.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author mumu
 * @vervion v1.0
 * @description
 * @date 2017/7/31 2017, 下午11:34
 */
@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext
public class OptApplicationTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    public MockMvc getMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        return mockMvc;
    }

}
