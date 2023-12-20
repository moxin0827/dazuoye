package com.kob.matchingsystem.service.impl;

import com.kob.matchingsystem.service.MatchingService;
import com.kob.matchingsystem.service.impl.utils.MatchingPool;
import org.springframework.stereotype.Service;

/**
 * 匹配服务的实现类。
 * 实现了MatchingService接口，用于处理玩家匹配的逻辑。
 */
@Service
public class MatchingServiceImpl implements MatchingService {
    /**
     * 公共静态的匹配池。
     * 用于管理和执行玩家的匹配任务。
     */
    public final static MatchingPool matchingPool = new MatchingPool();

    /**
     * 添加玩家到匹配队列的方法实现。
     * 接收用户ID、评分和机器人ID，将玩家添加到匹配队列中。
     *
     * @param userId 用户ID，标识要添加的玩家
     * @param rating 玩家的评分，用于匹配过程中的评级
     * @param botId 玩家使用的机器人ID
     * @return String 操作结果，通常为添加玩家成功的消息
     */
    @Override
    public String addPlayer(Integer userId, Integer rating, Integer botId) {
        System.out.println("add player: " + userId + " " + rating);
        matchingPool.addPlayer(userId, rating, botId);
        return "add player success";
    }

    /**
     * 从匹配队列中移除玩家的方法实现。
     * 接收用户ID，将指定玩家从匹配队列中移除。
     *
     * @param userId 用户ID，标识要移除的玩家
     * @return String 操作结果，通常为移除玩家成功的消息
     */
    @Override
    public String removePlayer(Integer userId) {
        System.out.println("remove player: " + userId);
        matchingPool.removePlayer(userId);
        return "remove player success";
    }
}
