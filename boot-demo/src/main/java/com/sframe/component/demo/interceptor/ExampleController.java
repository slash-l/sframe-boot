package com.sframe.component.demo.interceptor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mumu
 * @vervion v1.0
 * @description
 * @date 2017/3/12 2017, 下午10:34
 */
@RestController
public class ExampleController {

    @GetMapping("/user/home")
    @ResponseBody
    public String home(){
        System.out.println("---- mumu's home ----");
        return "mumu's home";
    }
}
