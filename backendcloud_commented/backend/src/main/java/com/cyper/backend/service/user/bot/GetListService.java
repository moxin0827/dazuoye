package com.cyper.backend.service.user.bot;

import com.cyper.backend.pojo.Bot;

import java.util.List;

/**
 * 获取机器人列表服务接口。
 * 定义了获取用户所有机器人列表的方法。
 */
public interface GetListService {

    /**
     * 获取机器人列表的方法。
     * 返回当前登录用户所拥有的所有机器人的列表。
     *
     * @return List<Bot> 用户拥有的机器人列表
     */
    List<Bot> getList();
}
