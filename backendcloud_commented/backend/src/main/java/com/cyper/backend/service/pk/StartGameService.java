package com.cyper.backend.service.pk;

/**
 * 开始游戏服务接口。
 * 定义了处理开始游戏的方法。
 */
public interface StartGameService {

    /**
     * 开始游戏的方法。
     * 用于初始化并开始游戏，接收玩家和机器人的ID作为参数。
     *
     * @param aId 玩家A的用户ID
     * @param aBotId 玩家A使用的机器人ID
     * @param bId 玩家B的用户ID
     * @param bBotId 玩家B使用的机器人ID
     * @return String 操作结果，通常为成功开始游戏的确认信息
     */
    String startGame(Integer aId, Integer aBotId, Integer bId, Integer bBotId);
}
