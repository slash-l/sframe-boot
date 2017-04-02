package com.sframe.demo.test.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @author mumu
 * @vervion v1.0
 * @description
 *
 * @SpringBootTest 不能和  @WebMvcTest 同时使用
 * 如果使用MockMvc对象的话，需要另外加上@AutoConfigureMockMvc注解
 *
 * @date 2017/4/2 2017, 下午4:46
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BookControllerTest3 {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testHome() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/book/home")).andExpect(MockMvcResultMatchers.status().isOk());
        mvc.perform(MockMvcRequestBuilders.get("/book/home")).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().string("bookhome"));
    }

    @Test
    public void testShow() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/book/show").param("id", "400")).andExpect(MockMvcResultMatchers.status().isOk());
        mvc.perform(MockMvcRequestBuilders.get("/book/show").param("id", "400")).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().string("book400"));
    }

}
