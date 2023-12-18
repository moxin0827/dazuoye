package com.kob.backend.service.pk;

/**
 * 接收机器人移动服务接口。
 * 定义了处理接收机器人移动的方法。
 */
public interface ReceiveBotMoveService {

    /**
     * 接收机器人移动的方法。
     * 用于接收并处理机器人的移动指令。
     *
     * @param userId 用户ID，标识哪个用户的机器人正在移动
     * @param direction 移动方向，表示机器人的移动方向
     * @return String 操作结果，通常为成功接收的确认信息
     */
    String receiveBotMove(Integer userId, Integer direction);
}
