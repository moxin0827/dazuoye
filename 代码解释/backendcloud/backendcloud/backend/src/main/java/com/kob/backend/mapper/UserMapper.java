package com.kob.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kob.backend.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户信息映射接口
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
