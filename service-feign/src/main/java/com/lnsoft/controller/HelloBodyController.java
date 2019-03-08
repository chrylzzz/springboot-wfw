package com.lnsoft.controller;

import com.lnsoft.client.IServiceHello;
import com.lnsoft.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created By Chr on 2019/2/27/0027.
 */

@RestController
public class HelloBodyController {

    @Autowired
    IServiceHello iServiceHello;

    /**
     * feign已经集成了负载均衡ribbon，所以8923端口并没有/helloBody拦截地址，就会调用@Feign的回调类执行—当前服务失败的方法
     * 这里调用的是eureka-client的：/helloBody
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHi(HttpServletRequest request,
                        HttpServletResponse response) {

        User user = new User();

        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));

        return iServiceHello.sayHello(user);
    }


}
