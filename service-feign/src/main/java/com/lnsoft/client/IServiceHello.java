package com.lnsoft.client;

import com.lnsoft.domain.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 1.第一步定义接口
 * //调用service-IServiceHello-chr-01的/helloBody接口，传递一个对象
 * </p>
 * Created By Chr on 2019/2/27/0027.
 */
//                  value就是服务名字(eureka-client的服务名字)，fallback就是服务调用失败之后执行的类，回调类（要写fallback才会开启）
@FeignClient(value = "service-client-chr-01",fallback = ServiceHelloFallback.class)
public interface IServiceHello {

    //value就是对应的eureka-client中接口的地址,
    @RequestMapping(value = "/helloBody",method = RequestMethod.GET)
    String sayHello(@RequestBody User user);//@RequestBody就是eureka-client的接收请求参数为对象的方法
}
