package com.cyper.backend.controller.user.bot;

import com.cyper.backend.service.user.bot.AddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 用户添加机器人控制器。
 */
@RestController
public class AddController {
    @Autowired
    private AddService addService;

    /**
     * 添加机器人。
     *
     * @param data 包含机器人相关信息的映射
     * @return 包含添加结果的映射
     */
    @PostMapping("/api/user/bot/add/")
    public Map<String, String> add(@RequestParam Map<String, String> data) {
        return addService.add(data);
    }
}
