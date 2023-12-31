package com.cyper.backend.service.impl.user.account;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cyper.backend.mapper.UserMapper;
import com.cyper.backend.pojo.User;
import com.cyper.backend.service.user.account.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 用户注册服务实现类。
 * 实现了RegisterService接口，用于处理用户的注册请求。
 */
@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;
    /**
     * 用户注册的方法。
     * 接收用户名和密码，进行用户注册的处理，并返回注册结果。
     *
     * @param username 用户名
     * @param password 密码
     * @param confirmedPassword 确认密码
     * @return 包含注册结果信息的映射
     */
    @Override
    public Map<String, String> register(String username, String password, String confirmedPassword) {
        Map<String, String> map = new HashMap<>();
        if (username == null) {
            map.put("error_message", "用户名不能为空");
            return map;
        }
        if (password == null || confirmedPassword == null) {
            map.put("error_message", "密码不能为空");
            return map;
        }

        username = username.trim();
        if (username.length() == 0) {
            map.put("error_message", "用户名不能为空");
            return map;
        }

        if (password.length() == 0 || confirmedPassword.length() == 0) {
            map.put("error_message", "密码不能为空");
            return map;
        }

        if (username.length() > 100) {
            map.put("error_message", "用户名长度不能大于100");
            return map;
        }

        if (password.length() > 100 || confirmedPassword.length() > 100) {
            map.put("error_message", "密码长度不能大于100");
            return map;
        }

        if (!password.equals(confirmedPassword)) {
            map.put("error_message", "两次输入的密码不一致");
            return map;
        }

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        List<User> users = userMapper.selectList(queryWrapper);
        if (!users.isEmpty()) {
            map.put("error_message", "用户名已存在");
            return map;
        }

        String encodedPassword = passwordEncoder.encode(password);
        String photo = "https://thirdqq.qlogo.cn/g?b=oidb&k=XQ2HtJxGYPbFicoz3hDlo5g&kti=ZWXIjQAAAAI&s=640&t=1694869542";
        User user = new User(null, username, encodedPassword, photo, 1500);
        userMapper.insert(user);

        map.put("error_message", "success");
        return map;
    }
}
