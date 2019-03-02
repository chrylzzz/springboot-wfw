package com.lnsoft.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created By Chr on 2019/2/27/0027.
 */
@Service
public class HelloService {

    /**
     * 使用restTemplate并不好，因为如果有多四五十个个参数的话，需要手动拼接，比较麻烦，
     * 所以使用feign（声明式的服务调用）来解决
     */
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 这是熔断机制，就是服务无法整成使用时的处理机制
     * @HystrixCommand：fallbackMethod定义降级的方法，一旦访问发生异常，就执行该方法
     * @param name
     * @return
     */
    @HystrixCommand(fallbackMethod = "helloError")
    public String helloService(String name) {
        //这里访问properties里的服务name来访问，不再使用端口访问
        return restTemplate.getForObject("http://service-client-chr-01/hello?name=" + name, String.class);
    }

    //降级方法，熔断机制
    public String helloError(String name) {
        return "Sorry," + name + ",error happens in Ribbon~";
    }
}
