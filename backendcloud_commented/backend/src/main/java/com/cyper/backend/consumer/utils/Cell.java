package com.cyper.backend.consumer.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 定义一个Cell类,用于表示棋盘上的单元格
 *
 * Cell类使用了Lombok注解,可以自动生成构造函数、getter和setter方法
 *
 * Cell类有两个属性:x和y,分别表示单元格的横坐标和纵坐标
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cell {
    int x, y;
}
