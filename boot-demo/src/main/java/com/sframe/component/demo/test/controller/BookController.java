package com.sframe.component.demo.test.controller;

import com.sframe.component.demo.test.dao.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mumu
 * @vervion v1.0
 * @description
 * @date 2017/4/2 2017, 下午3:45
 */
@RestController
@Slf4j
public class BookController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/book/home")
    public String home(){
        log.info("/book/home url is invoke");
        return "bookhome";
    }

    @GetMapping("/book/show")
    public String show(@RequestParam("id") String id){
        log.info("/book/show url is invoke");
        userRepository.addUser("");
        return "book"+id;
    }

}
