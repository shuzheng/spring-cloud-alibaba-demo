package cn.zhangshuzheng.spring.cloud.alibaba.dubbo.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudAlibabaDubboProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudAlibabaDubboProviderApplication.class, args);
    }

}
