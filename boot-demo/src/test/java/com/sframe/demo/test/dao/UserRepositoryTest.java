package com.sframe.demo.test.dao;

import com.sframe.component.demo.test.dao.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author mumu
 * @vervion v1.0
 * @description
 * @date 2017/4/2 2017, 下午3:58
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testAddUser() {
        Assert.assertEquals(Integer.valueOf(1), userRepository.addUser("root"));
        Assert.assertEquals(Integer.valueOf(0), userRepository.addUser(null));
    }

}
