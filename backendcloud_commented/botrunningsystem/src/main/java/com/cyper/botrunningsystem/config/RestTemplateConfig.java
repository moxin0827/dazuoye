package com.cyper.botrunningsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * RestTemplate配置类。
 * 用于配置Spring的RestTemplate，它是Spring用于REST客户端操作的工具。
 */
@Configuration
public class RestTemplateConfig {

    /**
     * 创建并返回一个RestTemplate实例。
     * RestTemplate提供了许多便利的方法来调用HTTP服务，并将HTTP响应转换为对象。
     *
     * @return RestTemplate Spring的RestTemplate实例
     */
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
