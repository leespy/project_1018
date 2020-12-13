package com.muse.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchDemo {

    private static final int nums = 5;
    public static CountDownLatch countDownLatch = new CountDownLatch(nums);

    public static void main(String[] args) throws Throwable {
        ExecutorService es = Executors.newFixedThreadPool(5);
        int i = 0;
        while (i < 5) {
            es.submit(new CountDownLatchRunning(countDownLatch, i));
            i++;
        }

        countDownLatch.await();
        System.out.println("任务全部执行完毕！");

        es.shutdown();
    }
}

class CountDownLatchRunning implements Runnable {

    private int i = 0;
    private CountDownLatch countDownLatch;

    public CountDownLatchRunning(CountDownLatch countDownLatch, int i) {
        this.i = i;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000); // 任务执行了1秒
            if (i == 3) {
                throw new RuntimeException();
            }
            System.out.println(Thread.currentThread().getName() + ": 任务执行完毕！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            countDownLatch.countDown();
        }
    }
}
