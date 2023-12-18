package com.cyper.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cyper.backend.pojo.Record;
import org.apache.ibatis.annotations.Mapper;

/**
 * 聊天记录映射接口
 */

@Mapper
public interface RecordMapper extends BaseMapper<Record> {
}
