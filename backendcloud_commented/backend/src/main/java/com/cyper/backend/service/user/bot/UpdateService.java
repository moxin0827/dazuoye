package com.cyper.backend.service.user.bot;

import java.util.Map;

/**
 * 机器人更新服务接口。
 * 定义了处理用户更新机器人信息的方法。
 */
public interface UpdateService {

    /**
     * 更新机器人信息的方法。
     * 接收包含要更新的机器人信息的数据，进行机器人信息更新的处理，并返回更新结果。
     *
     * @param data 包含要更新机器人信息的Map对象
     * @return 包含更新结果信息的映射
     */
    Map<String, String> update(Map<String, String> data);
}
