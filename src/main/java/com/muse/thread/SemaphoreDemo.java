package com.muse.thread;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo implements Runnable {

    Semaphore semaphore = new Semaphore(5);

    public static void main(String[] args) {
        SemaphoreDemo semaphoreDemo = new SemaphoreDemo();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(semaphoreDemo);
            thread.start();
        }
    }

    @Override
    public void run() {
        try {
             semaphore.acquire();
            Thread.sleep(1000);
            System.out.println(System.currentTimeMillis() + ", " + Thread.currentThread().getName() + ", 执行完毕！");
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
