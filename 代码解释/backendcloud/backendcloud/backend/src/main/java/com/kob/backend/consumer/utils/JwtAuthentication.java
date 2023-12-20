package com.kob.backend.consumer.utils;

import com.kob.backend.utils.JwtUtil;
import io.jsonwebtoken.Claims;

/**
 * 用于JWT身份验证的实用程序类。
 */
public class JwtAuthentication {

    /**
     * 从JWT令牌中提取用户ID。
     *
     * @param token JWT令牌
     * @return 从令牌中提取的用户ID
     * @throws RuntimeException 如果解析JWT令牌时出现错误
     */
    public static Integer getUserId(String token) {
        int userId = -1;
        try {
            Claims claims = JwtUtil.parseJWT(token);
            userId = Integer.parseInt(claims.getSubject());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return userId;
    }
}
