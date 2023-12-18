package com.cyper.matchingsystem;

import com.cyper.matchingsystem.service.impl.MatchingServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * 匹配系统的Spring Boot应用主类。
 * 负责启动整个匹配系统的Spring Boot应用。
 */
@SpringBootApplication
public class MatchingSystemApplication {
    /**
     * 主方法，用于启动Spring Boot应用。
     * 启动匹配线程池并运行应用。
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        MatchingServiceImpl.matchingPool.start();  // 启动匹配线程
        SpringApplication.run(MatchingSystemApplication.class, args);// 运行Spring Boot应用
    }
}
