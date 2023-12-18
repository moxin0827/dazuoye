package com.cyper.botrunningsystem.service.impl.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 机器人实体类。
 * 用于存储和管理机器人的基本信息。
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bot {
    /**
     * 用户ID，标识机器人所属的用户。
     */
    Integer userId;

    /**
     * 机器人的代码，定义了机器人的行为和逻辑。
     */
    String botCode;

    /**
     * 机器人运行时的输入数据。
     */
    String input;
}
