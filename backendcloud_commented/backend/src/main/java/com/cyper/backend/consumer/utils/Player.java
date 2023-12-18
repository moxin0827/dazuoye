package com.cyper.backend.consumer.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

/**
 * 表示游戏中的玩家。
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player {
    private Integer id;
    private Integer botId;  // -1表示手动控制，否则表示AI控制
    private String botCode;
    private Integer sx;
    private Integer sy;
    private List<Integer> steps;

    /**
     * 检查蛇在当前回合是否增长长度。
     *
     * @param step 当前步数
     * @return 如果蛇长度增加返回true，否则返回false
     */
    private boolean check_tail_increasing(int step) {
        if (step <= 10) return true;
        return step % 3 == 1;
    }

    /**
     * 根据移动步骤获取蛇所占据的单元格。
     *
     * @return 表示蛇移动的单元格列表
     */
    public List<Cell> getCells() {
        List<Cell> res = new ArrayList<>();
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int x = sx;
        int y = sy;
        int step = 0;
        res.add(new Cell(x, y));

        for (int d : steps) {
            x += dx[d];
            y += dy[d];
            res.add(new Cell(x, y));
            if (!check_tail_increasing(++step)) {
                res.remove(0);
            }
        }
        return res;
    }

    /**
     * 将蛇的移动步骤转换为字符串。
     *
     * @return 表示移动步骤的字符串
     */
    public String getStepsString() {
        StringBuilder res = new StringBuilder();
        for (int d : steps) {
            res.append(d);
        }
        return res.toString();
    }
}
