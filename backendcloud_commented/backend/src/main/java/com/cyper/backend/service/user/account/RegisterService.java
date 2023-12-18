package com.cyper.backend.service.user.account;

import java.util.Map;

/**
 * 用户注册服务接口。
 * 定义了处理用户注册请求的方法。
 */
public interface RegisterService {

    /**
     * 用户注册的方法。
     * 接收用户名、密码和确认密码，进行用户注册的处理，并返回注册结果。
     *
     * @param username 用户名
     * @param password 密码
     * @param confirmedPassword 确认密码
     * @return 包含注册结果信息的映射
     */
    public Map<String, String> register(String username, String password, String confirmedPassword);
}
