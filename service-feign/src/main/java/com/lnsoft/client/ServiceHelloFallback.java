package com.lnsoft.client;

import com.lnsoft.domain.User;
import org.springframework.stereotype.Service;

/**
 * 声明式的服务调用也有断路器的配置:
 * 该类必须实现@FeignClient的接口，才能进行(服务正常执行出错时才能执行fallback)
 * Created By Chr on 2019/2/27/0027.
 */
@Service
public class ServiceHelloFallback implements IServiceHello {

    @Override
    public String sayHello(User user) {
        return "Sorry:___" + user.getUsername() + "feign execute fail~~~~";
    }
}
