package com.cyper.botrunningsystem.service.impl.utils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
/**
 * 机器人池类。
 * 用于管理和执行机器人的任务队列。
 */
public class BotPool extends Thread {
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private final Queue<Bot> bots = new LinkedList<>();
    /**
     * 向机器人池添加机器人任务。
     * 将机器人任务添加到队列中并通知执行。
     *
     * @param userId 用户ID，标识机器人所属的用户
     * @param botCode 机器人的代码
     * @param input 机器人运行时的输入数据
     */
    public void addBot(Integer userId, String botCode, String input) {
        lock.lock();
        try {
            bots.add(new Bot(userId, botCode, input));
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
    /**
     * 消费（执行）机器人任务。
     * 执行给定的机器人任务。
     *
     * @param bot 待执行的机器人任务
     */
    private void consume(Bot bot) {
        Consumer consumer = new Consumer();
        consumer.startTimeout(2000, bot);
    }
    /**
     * 重写的run方法，用于机器人任务的持续执行。
     * 循环处理机器人任务队列中的任务。
     */
    @Override
    public void run() {
        while (true) {
            lock.lock();
            if (bots.isEmpty()) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    lock.unlock();
                    break;
                }
            } else {
                Bot bot = bots.remove();
                lock.unlock();
                consume(bot);  // 比较耗时，可能会执行几秒钟
            }
        }
    }
}
