package com.sframe.component.demo.monitor.metrics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mumu
 * @vervion v1.0
 * @description
 * @date 2017/4/1 2017, 下午11:36
 */
@RestController
public class UserController {

    @Autowired
    private CounterService counterService;

    @GetMapping("/user/count")
    public String count(){
        counterService.increment("user.count");
        return "home";
    }
}
