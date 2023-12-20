package com.kob.matchingsystem.controller;

import com.kob.matchingsystem.service.MatchingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
/**
 * 匹配系统控制器。
 * 负责处理匹配系统相关的HTTP请求。
 */
@RestController
public class MatchingController {
    @Autowired
    private MatchingService matchingService;
    /**
     * 添加玩家的HTTP请求处理方法。
     * 接收玩家的信息，调用服务来处理添加玩家的逻辑。
     *
     * @param data 包含玩家信息的MultiValueMap
     * @return String 操作结果，通常为添加玩家的处理结果
     */
    @PostMapping("/player/add/")
    public String addPlayer(@RequestParam MultiValueMap<String, String> data) {
        Integer userId = Integer.parseInt(Objects.requireNonNull(data.getFirst("user_id")));
        Integer rating = Integer.parseInt(Objects.requireNonNull(data.getFirst("rating")));
        Integer botId = Integer.parseInt(Objects.requireNonNull(data.getFirst("bot_id")));
        return matchingService.addPlayer(userId, rating, botId);
    }

   @PostMapping("/player/remove/")
    public String removePlayer(@RequestParam MultiValueMap<String, String> data) {
        // 从请求参数中获取user_id
        Integer userId = Integer.parseInt(Objects.requireNonNull(data.getFirst("user_id")));
        // 调用matchingService的removePlayer方法，移除玩家
        return matchingService.removePlayer(userId);
    }
}
