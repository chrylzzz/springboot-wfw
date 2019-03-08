package com.lnsoft.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created By Chr on 2019/2/27/0027.
 */
@Configuration
public class Myconfig {

    /**
     * 服务器调用用restTemplate
     * 客户端启用负载均衡ribbon
     * @return
     */
    @Bean
    @LoadBalanced//基于客户端的负载均衡：默认是轮询，直接加在restTemplate上，调用的方法也是具有负载均衡地
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
