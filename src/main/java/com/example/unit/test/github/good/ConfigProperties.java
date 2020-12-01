package com.example.unit.test.github.good;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConfigurationProperties(prefix="response")// 用来指定properties配置文件中的key前缀
@PropertySource("classpath:properties/mapping.properties")// 用来指定配置文件的位置
@Data
public class ConfigProperties {
    //RPC map<RPCcode码-前端返回code>
    private Map<String,Integer> mapping;
}