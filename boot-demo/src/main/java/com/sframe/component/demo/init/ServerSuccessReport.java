package com.sframe.component.demo.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author mumu
 * @vervion v1.0
 * @description
 * @date 2017/3/6 2017, 下午11:15
 */
@Component
public class ServerSuccessReport implements CommandLineRunner {

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("============ 应用已经成功启动 ===========");
    }

}
