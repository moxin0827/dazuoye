package com.cyper.backend.service.impl.user.bot;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cyper.backend.mapper.BotMapper;
import com.cyper.backend.pojo.Bot;
import com.cyper.backend.pojo.User;
import com.cyper.backend.service.impl.utils.UserDetailsImpl;
import com.cyper.backend.service.user.bot.GetListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * 机器人列表获取服务实现类。
 * 实现了GetListService接口，用于获取用户所有机器人的列表。
 */
@Service
public class GetListServiceImpl implements GetListService {
    @Autowired
    private BotMapper botMapper;
    /**
     * 获取机器人列表的方法。
     * 返回当前登录用户所拥有的所有机器人的列表。
     *
     * @return List<Bot> 用户拥有的机器人列表
     */
    @Override
    public List<Bot> getList() {
        UsernamePasswordAuthenticationToken authenticationToken =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl loginUser = (UserDetailsImpl) authenticationToken.getPrincipal();
        User user = loginUser.getUser();

        QueryWrapper<Bot> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", user.getId());

        return botMapper.selectList(queryWrapper);
    }
}
