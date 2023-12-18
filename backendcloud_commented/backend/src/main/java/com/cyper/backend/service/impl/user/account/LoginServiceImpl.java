package com.cyper.backend.service.impl.user.account;

import com.cyper.backend.pojo.User;
import com.cyper.backend.service.impl.utils.UserDetailsImpl;
import com.cyper.backend.service.user.account.LoginService;
import com.cyper.backend.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
/**
 * 用户登录服务实现类。
 * 实现了LoginService接口，用于处理用户登录并生成JWT令牌。
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;
    /**
     * 获取JWT令牌的方法。
     * 用户通过用户名和密码登录后，生成并返回JWT令牌。
     *
     * @param username 用户名
     * @param password 密码
     * @return 包含JWT令牌的映射
     */
    @Override
    public Map<String, String> getToken(String username, String password) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(username, password);

        Authentication authenticate = authenticationManager.authenticate(authenticationToken);  // 登录失败，会自动处理
        UserDetailsImpl loginUser = (UserDetailsImpl) authenticate.getPrincipal();
        User user = loginUser.getUser();
        String jwt = JwtUtil.createJWT(user.getId().toString());

        Map<String, String> map = new HashMap<>();
        map.put("error_message", "success");
        map.put("token", jwt);

        return map;
    }
}
