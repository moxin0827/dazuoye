package com.cyper.backend.controller.user.bot;

import com.cyper.backend.pojo.Bot;
import com.cyper.backend.service.user.bot.GetListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户获取机器人列表控制器。
 */
@RestController
public class GetListController {
    @Autowired
    private GetListService getListService;

    /**
     * 获取机器人列表。
     *
     * @return 机器人列表
     */
    @GetMapping("/api/user/bot/getlist/")
    public List<Bot> getList() {
        return getListService.getList();
    }
}
