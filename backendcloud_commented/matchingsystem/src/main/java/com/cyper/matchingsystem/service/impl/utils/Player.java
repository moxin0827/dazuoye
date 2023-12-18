package com.cyper.matchingsystem.service.impl.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 玩家实体类。
 * 用于存储和管理玩家的基本信息，包括用户ID、评分和机器人ID。
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player {
    /**
     * 用户ID，标识玩家。
     */
    private Integer userId;

    /**
     * 玩家的评分。
     */
    private Integer rating;

    /**
     * 玩家使用的机器人ID。
     */
    private Integer botId;

    /**
     * 玩家的等待时间。
     */
    private Integer waitingTime;  // 等待时间
}
