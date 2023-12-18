package com.cyper.backend.controller.pk;

import com.cyper.backend.service.pk.StartGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * 用于启动玩家对战机器人游戏的控制器。
 */
@RestController
public class StartGameController {
    @Autowired
    private StartGameService startGameService;

    /**
     * 处理使用提供的详细信息启动玩家和机器人之间的游戏。
     *
     * @param data 包含游戏玩家和机器人ID的多值映射
     * @return 初始化游戏后的响应
     */
    @PostMapping("/pk/start/game/")
    public String startGame(@RequestParam MultiValueMap<String, String> data) {
        Integer aId = Integer.parseInt(Objects.requireNonNull(data.getFirst("a_id")));
        Integer aBotId = Integer.parseInt(Objects.requireNonNull(data.getFirst("a_bot_id")));
        Integer bId = Integer.parseInt(Objects.requireNonNull(data.getFirst("b_id")));
        Integer bBotId = Integer.parseInt(Objects.requireNonNull(data.getFirst("b_bot_id")));
        return startGameService.startGame(aId, aBotId, bId, bBotId);
    }
}
