package com.cyper.botrunningsystem.service;

/**
 * 机器人运行服务接口。
 * 定义了处理机器人运行逻辑的方法。
 */
public interface BotRunningService {

    /**
     * 添加并运行机器人的方法。
     * 接收用户ID、机器人代码和输入数据，进行机器人运行的处理。
     *
     * @param userId 用户ID，标识执行机器人代码的用户
     * @param botCode 机器人的代码，即机器人的逻辑和行为定义
     * @param input 机器人运行时的输入数据
     * @return String 操作结果，通常为机器人运行的输出或执行状态
     */
    String addBot(Integer userId, String botCode, String input);
}
