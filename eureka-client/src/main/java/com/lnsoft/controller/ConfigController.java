package com.lnsoft.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 测试从配置中心服务端（最终从git仓库）读取配置
 * Created By Chr on 2019/2/28/0028.
 */
@RestController
@RefreshScope
public class ConfigController {

    private static Logger logger= LoggerFactory.getLogger(ConfigController.class);

    @Value("${changsha.pilot.name}")
    String message;

    @RequestMapping("/getConfig")
    public String getPropertyFromConfigServer(){
        String msg = "message from config server : " + message;
        logger.info(msg);
        return msg;
    }




















}
