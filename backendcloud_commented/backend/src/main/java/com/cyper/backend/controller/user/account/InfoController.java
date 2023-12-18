package com.cyper.backend.controller.user.account;

import com.cyper.backend.service.user.account.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 用户账户信息控制器
 */
@RestController
public class InfoController {
    @Autowired
    private InfoService infoService;

    /**
     * 获取用户账户信息
     *
     * @return 包含用户账户信息的映射
     */
    @GetMapping("/api/user/account/info/")
    public Map<String, String> getinfo() {
        return infoService.getinfo();
    }
}

