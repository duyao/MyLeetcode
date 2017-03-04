package com.dy.concurrent;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.LockSupport;

/**
 * Created by think on 2017-03-04.
 */
public class CountDownLatchDemo implements Runnable {


    //5个任务需要检查
    static final CountDownLatch end = new CountDownLatch(5);
    static final CountDownLatchDemo demo = new CountDownLatchDemo();

    public static void main(String[] args) throws InterruptedException {
        //执行5个线程完成检查，如果没有完成，所有线程就会阻塞，等待完成
        // 所以线程的个数必须要与倒计时个数相同
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executorService.submit(demo);
        }

        //等待通知
        end.await();
        System.out.println("Fired");
        executorService.shutdown();



    }

    @Override
    public void run() {
        Random r = new Random();
        try {
            Thread.sleep(r.nextInt(5) * 1000);
            end.countDown();
            System.out.println("chenk over, remaining "+end.getCount() );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
