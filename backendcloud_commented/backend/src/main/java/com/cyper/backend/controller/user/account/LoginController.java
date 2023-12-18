package com.cyper.backend.controller.user.account;

import com.cyper.backend.service.user.account.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 用户登录控制器。
 */
@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    /**
     * 获取用户令牌。
     *
     * @param map 包含用户名和密码的映射
     * @return 包含用户令牌的映射
     */
    @PostMapping("/api/user/account/token/")
    public Map<String, String> getToken(@RequestParam Map<String, String> map) {
        String username = map.get("username");
        String password = map.get("password");
        return loginService.getToken(username, password);
    }
}
