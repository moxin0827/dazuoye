package com.kob.matchingsystem.service;
/**
 * 匹配服务接口。
 * 定义了处理玩家匹配逻辑的方法。
 */
public interface MatchingService {
    /**
     * 添加玩家到匹配队列的方法。
     * 接收用户ID、评分和机器人ID，将玩家添加到匹配队列中。
     *
     * @param userId 用户ID，标识要添加的玩家
     * @param rating 玩家的评分，用于匹配过程中的评级
     * @param botId 玩家使用的机器人ID
     * @return String 操作结果，通常为添加玩家成功的消息
     */
    String addPlayer(Integer userId, Integer rating, Integer botId);
    /**
     * 从匹配队列中移除玩家的方法。
     * 接收用户ID，将指定玩家从匹配队列中移除。
     *
     * @param userId 用户ID，标识要移除的玩家
     * @return String 操作结果，通常为移除玩家成功的消息
     */
    String removePlayer(Integer userId);
}
