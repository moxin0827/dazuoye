package com.cyper.backend.controller.user.bot;

import com.cyper.backend.service.user.bot.RemoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 用户移除机器人控制器。
 */
@RestController
public class RemoveController {
    @Autowired
    private RemoveService removeService;

    /**
     * 移除机器人。
     *
     * @param data 包含机器人相关信息的映射
     * @return 包含移除结果的映射
     */
    @PostMapping("/api/user/bot/remove/")
    public Map<String, String> remove(@RequestParam Map<String, String> data) {
        return removeService.remove(data);
    }
}
