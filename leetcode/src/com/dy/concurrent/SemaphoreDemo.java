package com.dy.concurrent;

import java.util.Collections;
import java.util.concurrent.*;

/**
 * Created by think on 2017-03-04.
 */
public class SemaphoreDemo implements Runnable {
    //只有两个信号量
    final Semaphore semaphore = new Semaphore(2);
    static SemaphoreDemo demo = new SemaphoreDemo();

    public static void main(String[] args) {
        //有10个线程去抢夺
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executor.submit(demo);
        }


    }

    @Override
    public void run() {
        try {
            //获得
            semaphore.acquire();
            Thread.sleep(1000);
            System.out.println("Thread " + Thread.currentThread().getId() + " done!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //释放
            semaphore.release();
        }

    }
}
