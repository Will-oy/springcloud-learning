package com.atouyang.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {
    //简化了与http服务的通信方式，统一了RESTful的标准，封装了http链接，
    // 我们只需要传入url及返回值类型即可。相较于之前常用的HttpClient，
    // RestTemplate是一种更优雅的调用RESTful服务的方式。
    @Bean
//    @LoadBalanced//此注解赋予RestTemplate负载均衡的能力
    public RestTemplate getResTemplate(){
        return new RestTemplate();
    }
}
