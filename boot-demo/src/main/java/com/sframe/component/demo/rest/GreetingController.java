package com.sframe.component.demo.rest;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: GreetingController 
 * @Description: Greeting Controller
 * @author mumu
 * @date 2016年4月24日 上午12:00:04
 */
@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(method = RequestMethod.GET, value = "/greeting", produces = { "application/json;charset=UTF-8" })
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),String.format(template, name));
    }
    
}
