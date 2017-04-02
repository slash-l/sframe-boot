package com.sframe.demo.test.controller;

import com.sframe.component.demo.test.controller.BookController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @author mumu
 * @vervion v1.0
 * @description
 *
 * @WebMvcTest 不需要运行在web环境下，但是，需要指定controllers，表示需要测试哪些controllers
 * 这种方式只测试controller，controller里面的一些依赖，需要你自己去mock
 * @WebMvcTest 不会加载整个spring容器
 *
 * @date 2017/4/2 2017, 下午4:32
 */
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = BookController.class)
public class BookControllerTest2 {

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
