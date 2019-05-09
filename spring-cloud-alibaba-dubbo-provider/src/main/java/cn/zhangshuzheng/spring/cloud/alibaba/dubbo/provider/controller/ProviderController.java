package cn.zhangshuzheng.spring.cloud.alibaba.dubbo.provider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * provider
 *
 * @author ZhangShuzheng
 * @date 2019/5/8
 */
@RestController
@RequestMapping("/provider")
public class ProviderController {

    @Autowired
    private ConfigurableApplicationContext applicationContext;

    @Value("${server.port}")
    private Integer port;

    @GetMapping("/demo")
    public Object demo() {
        return "port= "+ port + ", name=" + applicationContext.getEnvironment().getProperty("user.name") + ", age=" + applicationContext.getEnvironment().getProperty("user.age");
    }

}
