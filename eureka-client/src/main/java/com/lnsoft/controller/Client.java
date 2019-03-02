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
public class Client {
    @Value("8922")
    String port;

    //接收单个参数的接口
    @RequestMapping("/hello")
    public String home(@RequestParam String name) {
        return "Hello," + name + ",call successfully,service on port" + port;
    }

    //接收对象的接口@RequestBody
    @RequestMapping("/helloBody")
    public String helloBody(@RequestBody User user) {
        return "HelloBody," + user.getUsername() + ",call successfully,service on port" + port;
    }
}
