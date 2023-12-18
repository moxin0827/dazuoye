/**
 * RestTemplateConfig是一个配置类,用于配置RestTemplate
 *
 * RestTemplateConfig使用了@Configuration注解,表示这是一个配置类
 *
 * RestTemplateConfig中定义了一个@Bean注解的getRestTemplate()方法,该方法返回一个RestTemplate对象
 * RestTemplate是一个用于实现HTTP请求和响应的类
 *
 * 因此,在RestTemplateConfig中使用@Bean注解的getRestTemplate()方法,可以配置RestTemplate,从而实现HTTP请求和响应的功能
 *
 */

package com.cyper.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
