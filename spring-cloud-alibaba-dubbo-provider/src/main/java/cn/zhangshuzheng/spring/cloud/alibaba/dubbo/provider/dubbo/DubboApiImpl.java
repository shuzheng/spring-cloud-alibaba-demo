package cn.zhangshuzheng.spring.cloud.alibaba.dubbo.provider.dubbo;

import cn.zhangshuzheng.spring.cloud.alibaba.dubbo.api.DubboApi;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author ZhangShuzheng
 * @date 2019/5/8
 */
@Service
public class DubboApiImpl implements DubboApi {

    @Value("${server.port}")
    private Integer port;

    @Override
    public String demo() {
        return "port= "+ port;
    }

}
