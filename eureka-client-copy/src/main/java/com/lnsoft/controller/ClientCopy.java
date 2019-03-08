package com.lnsoft.controller;

import com.lnsoft.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 供予调用
 * Created By Chr on 2019/2/27/0027.
 */
@RestController
public class ClientCopy {
    @Value("8923")
    String port;

    @RequestMapping("/hello")
    public String home(@RequestParam String name) {
        return "Hello," + name + ",call successfully,service on port" + port;
    }

    /**
     * 注释，模拟ribbon的熔断降级机制,feign和zuul都继承了熔断机制
     */
    //接收对象的接口@RequestBody
//    @RequestMapping("/helloBody")
//    public String helloBody(@RequestBody User user) {
//        return "HelloBody," + user.getUsername() + ",call successfully,service on port" + port;
//    }
}
