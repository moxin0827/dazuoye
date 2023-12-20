package com.kob.backend.controller.record;

import com.alibaba.fastjson.JSONObject;
import com.kob.backend.service.record.GetRecordListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 用于检索游戏记录列表的控制器。
 */
@RestController
public class GetRecordListController {
    @Autowired
    private GetRecordListService getRecordListService;

    /**
     * 检索指定页面的游戏记录列表。
     *
     * @param data 包含记录检索页数的映射
     * @return 表示指定页面游戏记录列表的JSON对象
     */
    @GetMapping("/api/record/getlist/")
    public JSONObject getList(@RequestParam Map<String, String> data) {
        Integer page = Integer.parseInt(data.get("page"));
        return getRecordListService.getList(page);
    }
}
