package com.kob.backend.controller.ranklist;

import com.alibaba.fastjson.JSONObject;
import com.kob.backend.service.ranklist.GetRanklistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 用于检索排行榜的控制器。
 */
@RestController
public class GetRanklistController {
    @Autowired
    private GetRanklistService getRanklistService;

    /**
     * 检索指定页面的排行榜。
     *
     * @param data 包含排行榜检索页数的映射
     * @return 表示指定页面排行榜的JSON对象
     */
    @GetMapping("/api/ranklist/getlist/")
    public JSONObject getList(@RequestParam Map<String, String> data) {
        Integer page = Integer.parseInt(data.get("page"));
        return getRanklistService.getList(page);
    }
}
