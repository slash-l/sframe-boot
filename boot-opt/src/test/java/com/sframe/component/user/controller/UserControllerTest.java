package com.sframe.component.user.controller;

import com.sframe.component.OptApplicationTest;
import com.sframe.component.user.constant.UserUrl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.test.web.servlet.RequestBuilder;
import org.testng.annotations.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author mumu
 * @vervion v1.0
 * @description
 * @date 2017/7/31 2017, 下午11:47
 */
@Slf4j
public class UserControllerTest extends OptApplicationTest {

    @Test
    public void testUserController() throws Exception {
        log.info("test");
        RequestBuilder request = null;
        request = get(UserUrl.USER_PAGE);
        super.getMockMvc().perform(request)
                .andExpect(status().isOk());
    }

}
