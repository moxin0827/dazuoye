package com.kob.backend.service.record;

import com.alibaba.fastjson.JSONObject;

/**
 * 获取记录列表服务接口。
 * 定义了获取用户游戏记录列表的方法。
 */
public interface GetRecordListService {

    /**
     * 获取游戏记录列表的方法。
     * 根据提供的页码参数获取用户的游戏记录列表。
     *
     * @param page 请求的页码
     * @return JSONObject 包含游戏记录列表的JSON对象
     */
    JSONObject getList(Integer page);
}
