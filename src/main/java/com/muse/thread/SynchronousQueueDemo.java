package com.muse.thread;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class SynchronousQueueDemo {

    public static void main(String[] args) {
        SynchronousQueue synchronousQueue = new SynchronousQueue();
//        synchronousQueue.offer(1);
//        synchronousQueue.offer(2);
//        try {
//            synchronousQueue.poll(TimeUnit.SECONDS.toNanos(60*10), TimeUnit.NANOSECONDS);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        synchronousQueue.offer(3);
//        synchronousQueue.offer(4);
//        synchronousQueue.offer(5);

        new Thread(() -> {
            synchronousQueue.offer(1);
        }).start();

        new Thread(() -> {
            try {
                synchronousQueue.poll(TimeUnit.SECONDS.toNanos(60*10), TimeUnit.NANOSECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            synchronousQueue.offer(3);
        }).start();

    }
}
