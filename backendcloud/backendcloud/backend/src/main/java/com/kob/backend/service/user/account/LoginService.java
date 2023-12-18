package com.kob.backend.service.user.account;

import java.util.Map;

/**
 * 用户登录服务接口。
 * 定义了处理用户登录并生成JWT令牌的方法。
 */
public interface LoginService {

    /**
     * 获取JWT令牌的方法。
     * 用户通过用户名和密码登录后，生成并返回JWT令牌。
     *
     * @param username 用户名
     * @param password 密码
     * @return Map<String, String> 包含JWT令牌的映射
     */
    public Map<String, String> getToken(String username, String password);
}
