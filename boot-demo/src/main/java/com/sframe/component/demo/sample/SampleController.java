package com.sframe.component.demo.sample;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName: SampleController 
 * @Description: 第一个 spring boot 程序
 * @author mumu
 * @date 2016年4月23日 下午11:53:01 
 */
@Controller
@EnableAutoConfiguration
public class SampleController {

	@RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }
    
}
