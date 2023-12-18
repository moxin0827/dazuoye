package com.kob.backend.service.user.bot;

import java.util.Map;

/**
 * 机器人添加服务接口。
 * 定义了处理用户添加机器人的方法。
 */
public interface AddService {

    /**
     * 添加机器人的方法。
     * 接收包含机器人信息的数据，进行机器人添加的处理，并返回添加结果。
     *
     * @param data 包含机器人信息的Map对象
     * @return Map<String, String> 包含添加结果信息的映射
     */
    Map<String, String> add(Map<String, String> data);
}
