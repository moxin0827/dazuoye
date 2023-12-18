package com.cyper.matchingsystem.service.impl.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
/**
 * 匹配池类。
 * 管理和执行玩家匹配的任务。
 */
@Component
public class MatchingPool extends Thread {
    private static List<Player> players = new ArrayList<>();
    private final ReentrantLock lock = new ReentrantLock();
    private static RestTemplate restTemplate;
    private final static String startGameUrl = "http://127.0.0.1:3000/pk/start/game/";
    /**
     * 设置RestTemplate。
     * 用于HTTP请求的发送。
     *
     * @param restTemplate Spring的RestTemplate对象
     */
    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        MatchingPool.restTemplate = restTemplate;
    }
    /**
     * 添加玩家到匹配池的方法。
     * 接收用户ID、评分和机器人ID，将玩家添加到匹配池中。
     *
     * @param userId 用户ID，标识要添加的玩家
     * @param rating 玩家的评分
     * @param botId 玩家使用的机器人ID
     */
    public void addPlayer(Integer userId, Integer rating, Integer botId) {
        lock.lock();
        try {
            players.add(new Player(userId, rating, botId, 0));
        } finally {
            lock.unlock();
        }
    }
    /**
     * 从匹配池中移除玩家的方法。
     * 根据用户ID移除匹配池中的玩家。
     *
     * @param userId 用户ID，标识要移除的玩家
     */
    public void removePlayer(Integer userId) {
        lock.lock();
        try {
            List<Player> newPlayers = new ArrayList<>();
            for (Player player: players) {
                if (!player.getUserId().equals(userId)) {
                    newPlayers.add(player);
                }
            }
            players = newPlayers;
        } finally {
            lock.unlock();
        }
    }
    /**
     * 增加所有当前玩家的等待时间。
     */
   private void increaseWaitingTime() {  // 将所有当前玩家的等待时间加1
        for (Player player: players) {
            player.setWaitingTime(player.getWaitingTime() + 1);
        }
    }
    /**
     * 检查两名玩家是否匹配。
     * 根据评分差和等待时间判断玩家是否匹配。
     *
     * @param a 第一名玩家
     * @param b 第二名玩家
     * @return boolean 表示两名玩家是否匹配
     */
    private boolean checkMatched(Player a, Player b) {  // 判断两名玩家是否匹配
        int ratingDelta = Math.abs(a.getRating() - b.getRating());
        int waitingTime = Math.min(a.getWaitingTime(), b.getWaitingTime());
        return ratingDelta <= waitingTime * 10;
    }
    /**
     * 向两名匹配成功的玩家发送结果。
     *
     * @param a 第一名玩家
     * @param b 第二名玩家
     */
    private void sendResult(Player a, Player b) {  // 返回匹配结果
        System.out.println("send result: " + a + " " + b);
        MultiValueMap<String, String> data = new LinkedMultiValueMap<>();
        data.add("a_id", a.getUserId().toString());
        data.add("a_bot_id", a.getBotId().toString());
        data.add("b_id", b.getUserId().toString());
        data.add("b_bot_id", b.getBotId().toString());
        restTemplate.postForObject(startGameUrl, data, String.class);
    }
    /**
     * 尝试匹配所有玩家。
     * 遍历所有玩家，尝试找到匹配对手。
     */
    private void matchPlayers() {  // 尝试匹配所有玩家
        boolean[] used = new boolean[players.size()];
        for (int i = 0; i < players.size(); i ++ ) {
            if (used[i]) continue;
            for (int j = i + 1; j < players.size(); j ++ ) {
                if (used[j]) continue;
                Player a = players.get(i), b = players.get(j);
                if (checkMatched(a, b)) {
                    used[i] = used[j] = true;
                    sendResult(a, b);
                    break;
                }
            }
        }

        List<Player> newPlayers = new ArrayList<>();
        for (int i = 0; i < players.size(); i ++ ) {
            if (!used[i]) {
                newPlayers.add(players.get(i));
            }
        }
        players = newPlayers;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                lock.lock();
                try {
                    increaseWaitingTime();
                    matchPlayers();
                } finally {
                    lock.unlock();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
