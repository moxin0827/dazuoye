package com.kob.botrunningsystem.utils;

/**
 * 机器人接口。
 * 定义了机器人决定下一步动作的方法。
 */
public interface BotInterface {

    /**
     * 决定机器人下一步动作的方法。
     * 根据提供的输入数据来决定机器人的下一个移动。
     *
     * @param input 提供给机器人的输入数据
     * @return Integer 表示机器人下一步动作的整数值
     */
    Integer nextMove(String input);
}
