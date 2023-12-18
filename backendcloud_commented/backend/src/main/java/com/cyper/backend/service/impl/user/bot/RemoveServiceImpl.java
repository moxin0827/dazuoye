package com.cyper.backend.service.impl.user.bot;

import com.cyper.backend.mapper.BotMapper;
import com.cyper.backend.pojo.Bot;
import com.cyper.backend.pojo.User;
import com.cyper.backend.service.impl.utils.UserDetailsImpl;
import com.cyper.backend.service.user.bot.RemoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
/**
 * 机器人移除服务实现类。
 * 实现了RemoveService接口，用于处理用户移除机器人的请求。
 */
@Service
public class RemoveServiceImpl implements RemoveService {
    @Autowired
    private BotMapper botMapper;
    /**
     * 移除机器人的方法。
     * 接收包含要移除机器人信息的数据，进行机器人移除的处理，并返回移除结果。
     *
     * @param data 包含要移除机器人信息的Map对象
     * @return Map<String, String> 包含移除结果信息的映射
     */
    @Override
    public Map<String, String> remove(Map<String, String> data) {
        UsernamePasswordAuthenticationToken authenticationToken =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl loginUser = (UserDetailsImpl) authenticationToken.getPrincipal();
        User user = loginUser.getUser();

        int bot_id = Integer.parseInt(data.get("bot_id"));
        Bot bot = botMapper.selectById(bot_id);
        Map<String, String> map = new HashMap<>();

        if (bot == null) {
            map.put("error_message", "Bot不存在或已被删除");
            return map;
        }

        if (!bot.getUserId().equals(user.getId())) {
            map.put("error_message", "没有权限删除该Bot");
            return map;
        }

        botMapper.deleteById(bot_id);

        map.put("error_message", "success");
        return map;
    }
}
