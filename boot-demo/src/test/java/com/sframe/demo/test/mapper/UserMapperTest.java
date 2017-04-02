package com.sframe.demo.test.mapper;

import com.sframe.component.demo.test.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author mumu
 * @vervion v1.0
 * @description
 * mock 测试
 * @date 2017/4/2 2017, 下午3:29
 */
@RunWith(SpringRunner.class)
public class UserMapperTest {

    @MockBean
    private UserMapper userMapper;

    @Before
    public void init(){
        BDDMockito.given(userMapper.createUser("admin")).willReturn(Integer.valueOf(1));
        BDDMockito.given(userMapper.createUser("")).willReturn(Integer.valueOf(0));
        BDDMockito.given(userMapper.createUser(null)).willThrow(NullPointerException.class);
    }

    @Test(expected = NullPointerException.class)
    public void testCreateUser(){
        Assert.assertEquals(Integer.valueOf(1), userMapper.createUser("admin"));
        Assert.assertEquals(Integer.valueOf(0), userMapper.createUser(""));
        Assert.assertEquals(Integer.valueOf(0), userMapper.createUser(null));
    }

}
