package com.cyper.backend.service.impl.pk;

import com.cyper.backend.consumer.WebSocketServer;
import com.cyper.backend.consumer.utils.Game;
import com.cyper.backend.service.pk.ReceiveBotMoveService;
import org.springframework.stereotype.Service;

/**
 * 接收机器人移动的服务实现。
 * 实现了ReceiveBotMoveService接口，用于处理机器人的移动。
 */
@Service
public class ReceiveBotMoveServiceImpl implements ReceiveBotMoveService {

    /**
     * 接收机器人的移动指令，并处理。
     * 根据用户ID和方向来更新游戏状态。
     *
     * @param userId 用户ID，用于标识哪个用户的机器人正在移动
     * @param direction 移动方向，表示机器人的移动方向
     * @return String 返回操作的结果，通常是成功接收消息的确认
     */
    @Override
    public String receiveBotMove(Integer userId, Integer direction) {
        System.out.println("receive bot move: " + userId + " " + direction + " ");
        if (WebSocketServer.users.get(userId) != null) {
            Game game = WebSocketServer.users.get(userId).game;
            if (game != null) {
                if (game.getPlayerA().getId().equals(userId)) {
                    game.setNextStepA(direction);
                } else if (game.getPlayerB().getId().equals(userId)) {
                    game.setNextStepB(direction);
                }
            }
        }

        return "receive bot move success";
    }
}
