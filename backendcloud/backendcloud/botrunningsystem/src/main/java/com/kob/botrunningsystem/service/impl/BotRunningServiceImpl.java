package com.kob.botrunningsystem.service.impl;

import com.kob.botrunningsystem.service.BotRunningService;
import com.kob.botrunningsystem.service.impl.utils.BotPool;
import org.springframework.stereotype.Service;
/**
 * 机器人运行服务实现类。
 * 实现了BotRunningService接口，用于处理机器人运行的逻辑。
 */
@Service
public class BotRunningServiceImpl implements BotRunningService {
    /**
     * 公共静态的机器人池。
     * 用于管理和执行机器人任务。
     */
    public final static BotPool botPool = new BotPool();
    /**
     * 添加机器人的方法实现。
     * 接收用户ID、机器人代码和输入数据，将机器人任务添加到机器人池中。
     *
     * @param userId 用户ID，标识机器人所属的用户
     * @param botCode 机器人的代码
     * @param input 机器人运行时的输入数据
     * @return String 操作结果，通常为添加机器人成功的消息
     */
    @Override
    public String addBot(Integer userId, String botCode, String input) {
        System.out.println("add bot: " + userId + " " + botCode + " " + input);
        botPool.addBot(userId, botCode, input);
        return "add bot success";
    }
}
