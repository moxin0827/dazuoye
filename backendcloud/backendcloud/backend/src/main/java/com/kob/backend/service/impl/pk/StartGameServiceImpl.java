package com.kob.backend.service.impl.pk;

import com.kob.backend.consumer.WebSocketServer;
import com.kob.backend.service.pk.StartGameService;
import org.springframework.stereotype.Service;

/**
 * 开始游戏的服务实现类。
 * 实现了StartGameService接口，用于初始化并开始游戏。
 */
@Service
public class StartGameServiceImpl implements StartGameService {

    /**
     * 开始游戏的方法。
     * 根据玩家和机器人的ID初始化游戏，并通知WebSocket服务器开始游戏。
     *
     * @param aId 玩家A的用户ID
     * @param aBotId 玩家A使用的机器人ID
     * @param bId 玩家B的用户ID
     * @param bBotId 玩家B使用的机器人ID
     * @return String 返回操作的结果，通常是成功开始游戏的确认
     */
    @Override
    public String startGame(Integer aId, Integer aBotId, Integer bId, Integer bBotId) {
        System.out.println("start game: " + aId + " " + bId);
        WebSocketServer.startGame(aId, aBotId, bId, bBotId);
        return "start game success";
    }
}
