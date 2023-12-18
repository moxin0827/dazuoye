package com.kob.backend.service.user.account;

import java.util.Map;

/**
 * 用户信息服务接口。
 * 定义了获取当前登录用户信息的方法。
 */
public interface InfoService {

    /**
     * 获取当前登录用户信息的方法。
     * 返回一个包含用户信息的Map对象。
     *
     * @return Map<String, String> 包含用户信息的映射
     */
    public Map<String, String> getinfo();
}
