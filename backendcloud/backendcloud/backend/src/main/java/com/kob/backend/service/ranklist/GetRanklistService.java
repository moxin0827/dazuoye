package com.kob.backend.service.ranklist;

import com.alibaba.fastjson.JSONObject;

/**
 * 获取排行榜服务接口。
 * 定义了获取用户排行榜数据的方法。
 */
public interface GetRanklistService {

    /**
     * 获取排行榜数据的方法。
     * 根据提供的页码参数获取用户的排行榜数据。
     *
     * @param page 请求的页码
     * @return JSONObject 包含排行榜数据的JSON对象
     */
    JSONObject getList(Integer page);
}
