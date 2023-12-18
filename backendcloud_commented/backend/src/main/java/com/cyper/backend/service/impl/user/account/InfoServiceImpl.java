package com.cyper.backend.service.impl.user.account;

import com.cyper.backend.pojo.User;
import com.cyper.backend.service.impl.utils.UserDetailsImpl;
import com.cyper.backend.service.user.account.InfoService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
/**
 * 用户信息服务实现类。
 * 实现了InfoService接口，用于获取当前登录用户的信息。
 */
@Service
public class InfoServiceImpl implements InfoService {
    /**
     * 获取当前登录用户的信息。
     * 返回一个包含用户信息的Map对象。
     *
     * @return Map<String, String> 包含用户信息的映射
     */
    @Override
    public Map<String, String> getinfo() {
        UsernamePasswordAuthenticationToken authentication =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();

        UserDetailsImpl loginUser = (UserDetailsImpl) authentication.getPrincipal();
        User user = loginUser.getUser();

        Map<String, String> map = new HashMap<>();
        map.put("error_message", "success");
        map.put("id", user.getId().toString());
        map.put("username", user.getUsername());
        map.put("photo", user.getPhoto());
        return map;
    }
}
