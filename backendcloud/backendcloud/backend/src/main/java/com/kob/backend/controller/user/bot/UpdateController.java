package com.kob.backend.controller.user.bot;

import com.kob.backend.service.user.bot.UpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 用户更新机器人信息控制器。
 */
@RestController
public class UpdateController {
    @Autowired
    private UpdateService updateService;

    /**
     * 更新机器人信息。
     *
     * @param data 包含机器人相关信息的映射
     * @return 包含更新结果的映射
     */
    @PostMapping("/api/user/bot/update/")
    public Map<String, String> update(@RequestParam Map<String, String> data) {
        return updateService.update(data);
    }
}
