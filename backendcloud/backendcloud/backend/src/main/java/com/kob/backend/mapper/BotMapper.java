/**
 * 机器人信息映射接口
 * package com.kob.backend.mapper：位于 com.kob.backend 包下的 mapper 包中。
 * import com.baomidou.mybatisplus.core.mapper.BaseMapper;：导入 MyBatis-Plus 的 BaseMapper 类，以继承并实现机器人信息映射接口。
 * import com.kob.backend.pojo.Bot;：导入机器人信息实体类 Bot。
 * @Mapper：使用 MyBatis-Plus 的注解，表示这是一个映射接口。
 */

package com.kob.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kob.backend.pojo.Bot;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BotMapper extends BaseMapper<Bot> {
}