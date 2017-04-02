package com.sframe.component.demo.test.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

/**
 * @author mumu
 * @vervion v1.0
 * @description
 * @date 2017/4/2 2017, 下午3:40
 */
@Repository
@Slf4j
public class UserRepository {

    public Integer addUser(String userName){
        log.info("user repository add user [user name = "+ userName +"]");
        if(userName == null){
            return 0;
        }
        return 1;
    }
}
