/**
 * WebSocketConfig是一个配置类,用于配置WebSocket
 *
 * WebSocketConfig使用了@Configuration注解,表示这是一个配置类
 *
 * WebSocketConfig中定义了一个@Bean注解的serverEndpointExporter()方法,该方法返回一个ServerEndpointExporter对象
 * ServerEndpointExporter是一个Spring WebSocket API中的类,用于自动扫描并注册ServerEndpoint
 *
 * 因此,在WebSocketConfig中使用@Bean注解的serverEndpointExporter()方法,可以自动注册WebSocket的ServerEndpoint,从而实现WebSocket的服务
 * @auther 张恒嘉
 * @date 2023/11/10
 */
package com.cyper.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@Configuration
public class WebSocketConfig {

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {

        return new ServerEndpointExporter();
    }
}
