package com.muse.thread;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 测试CountDownLatch
 *
 * @author muse
 */
public class CountDownLatchDemo {

    private static final int NUMS = 5;
    public static CountDownLatch countDownLatch = new CountDownLatch(NUMS);

    public static void main(String[] args) throws Throwable {
        ExecutorService es = Executors.newCachedThreadPool();
        int i = 0;
        while (i < 15) {
            es.submit(new CountDownLatchRunning(countDownLatch, i));
            i++;
        }

        countDownLatch.await();
        System.out.println("任务全部执行完毕！");

        es.shutdown();
    }
}

class CountDownLatchRunning implements Runnable {

    private int i;
    private CountDownLatch countDownLatch;

    public CountDownLatchRunning(CountDownLatch countDownLatch, int i) {
        this.i = i;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            Random random = new Random();
            Integer sleepTime = random.nextInt(1000);
            TimeUnit.MILLISECONDS.sleep(sleepTime); // 任务执行了1秒
//            if (i == 3) {
//                throw new RuntimeException();
//            }
            System.out.println(Thread.currentThread().getName() + ": 任务执行完毕！sleepTime=" + sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            countDownLatch.countDown();
        }
    }
}
