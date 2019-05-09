package cn.zhangshuzheng.spring.cloud.alibaba.dubbo.consumer.controller;

import cn.zhangshuzheng.spring.cloud.alibaba.dubbo.api.DubboApi;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * consumer
 *
 * @author ZhangShuzheng
 * @date 2019/5/8
 */
@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    private RestTemplate restTemplate = new RestTemplate();

    @Reference(check = false)
    private DubboApi dubboApi;

    @GetMapping("/demo")
    public Object demo() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("spring-cloud-alibaba-dubbo-provider");
        String url = String.format("http://%s:%s/provider/demo", serviceInstance.getHost(), serviceInstance.getPort());
        System.out.println("request url:" + url);
        return restTemplate.getForObject(url, String.class);
    }

    @GetMapping("/dubbo")
    public Object dubbo() {
        return dubboApi.demo();
    }

}
