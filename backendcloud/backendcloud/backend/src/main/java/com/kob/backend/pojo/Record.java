package com.kob.backend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 记录实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Record {
    /**
     * 主键ID，自动生成
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 玩家A的ID
     */
    private Integer aId;

    /**
     * 玩家A的座位号
     */
    private Integer aSx;

    /**
     * 玩家A的座位号
     */
    private Integer aSy;

    /**
     * 玩家B的ID
     */
    private Integer bId;

    /**
     * 玩家B的座位号
     */
    private Integer bSx;

    /**
     * 玩家B的座位号
     */
    private Integer bSy;

    /**
     * 玩家A的步骤
     */
    private String aSteps;

    /**
     * 玩家B的步骤
     */
    private String bSteps;

    /**
     * 地图信息
     */
    private String map;

    /**
     * 输赢方
     */
    private String loser;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date createtime;
}

