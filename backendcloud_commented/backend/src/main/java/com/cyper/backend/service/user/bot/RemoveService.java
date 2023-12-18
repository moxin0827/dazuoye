package com.cyper.backend.service.user.bot;

import java.util.Map;

/**
 * 机器人移除服务接口。
 * 定义了处理用户移除机器人的方法。
 */
public interface RemoveService {

    /**
     * 移除机器人的方法。
     * 接收包含要移除机器人信息的数据，进行机器人移除的处理，并返回移除结果。
     *
     * @param data 包含要移除机器人信息的Map对象
     * @return 包含移除结果信息的映射
     */
    Map<String, String> remove(Map<String, String> data);
}
