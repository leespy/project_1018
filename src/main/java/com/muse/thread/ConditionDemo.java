package com.muse.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试Condition
 *
 * @author muse
 */
public class ConditionDemo {

    public static ReentrantLock lock = new ReentrantLock();
    public static Condition condition = lock.newCondition();

    public static void main(String[] args) throws Throwable {
        new Thread(() -> {
            try {
                lock.lock();
                System.out.println(System.currentTimeMillis() + " " + Thread.currentThread().getName() + ", 线程开始等待！");
                condition.await(); // 释放当前锁，进入等待中；其中，调用await，一定要先获得锁。
                System.out.println(System.currentTimeMillis() + " " + Thread.currentThread().getName() + ", 线程继续执行！");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();

        Thread.sleep(1000);
        System.out.println(System.currentTimeMillis() + " " + Thread.currentThread().getName() + ", 主线程睡了1秒钟！");
        lock.lock();
        condition.signal(); // 调用signal之前，一定要先获得锁，所以先调用了lock.lock()
        lock.unlock();
    }
}

