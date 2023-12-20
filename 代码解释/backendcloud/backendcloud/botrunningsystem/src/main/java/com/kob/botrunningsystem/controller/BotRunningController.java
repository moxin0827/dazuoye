package com.kob.botrunningsystem.controller;

import com.kob.botrunningsystem.service.BotRunningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * 机器人运行控制器。
 * 处理有关机器人运行的HTTP请求。
 */
@RestController
public class BotRunningController {

    @Autowired
    private BotRunningService botRunningService;

    /**
     * 添加机器人的HTTP请求处理方法。
     * 接收用户ID、机器人代码和输入数据，调用服务来处理添加机器人的逻辑。
     *
     * @param data 包含机器人信息的MultiValueMap
     * @return String 操作结果，通常为添加机器人的处理结果
     */
    @PostMapping("/bot/add/")
    public String addBot(@RequestParam MultiValueMap<String, String> data) {
        Integer userId = Integer.parseInt(Objects.requireNonNull(data.getFirst("user_id")));
        String botCode = data.getFirst("bot_code");
        String input = data.getFirst("input");
        return botRunningService.addBot(userId, botCode, input);
    }
}
