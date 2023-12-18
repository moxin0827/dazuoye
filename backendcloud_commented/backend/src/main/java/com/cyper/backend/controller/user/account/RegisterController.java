package com.cyper.backend.controller.user.account;

import com.cyper.backend.service.user.account.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 用户注册控制器。
 */
@RestController
public class RegisterController {
    @Autowired
    private RegisterService registerService;

    /**
     * 用户注册。
     *
     * @param map 包含用户名、密码和确认密码的映射
     * @return 包含注册结果的映射
     */
    @PostMapping("/api/user/account/register/")
    public Map<String, String> register(@RequestParam Map<String, String> map) {
        String username = map.get("username");
        String password = map.get("password");
        String confirmedPassword = map.get("confirmedPassword");
        return registerService.register(username, password, confirmedPassword);
    }
}
