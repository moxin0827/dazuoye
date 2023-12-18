package com.kob.botrunningsystem;

import com.kob.botrunningsystem.service.impl.BotRunningServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 机器人运行系统的Spring Boot应用主类。
 * 负责启动整个机器人运行系统的Spring Boot应用。
 */
@SpringBootApplication
public class BotRunningSystemApplication {

    /**
     * 主方法，用于启动Spring Boot应用。
     * 启动机器人池并运行应用。
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        // 启动机器人池
        BotRunningServiceImpl.botPool.start();

        // 运行Spring Boot应用
        SpringApplication.run(BotRunningSystemApplication.class, args);
    }
}
