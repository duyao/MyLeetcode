package com.dy.concurrent;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * Created by think on 2017-03-04.
 */
public class AtomicIntegerFieldUpdaterDemo {
    public static class Student {
        int id;
        //必须为volatile类型
        volatile int score;
    }

    public static void main(String[] args) {
        //构造方法，一个参数是类，第二是参数名
        AtomicIntegerFieldUpdater updater = AtomicIntegerFieldUpdater.
                newUpdater(Student.class, "score");
        Random r = new Random();
        Student stu = new Student();
        //验证结果是否正确
        AtomicInteger comparedInteger = new AtomicInteger();
        Thread[] threads = new Thread[1000];
        for (int i = 0; i < 1000; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    if (r.nextInt() > 10) {
                        updater.incrementAndGet(stu);
                        comparedInteger.incrementAndGet();

                    }
                }
            });
            threads[i].start();

        }
        //等待所有线程完成
        for (int i = 0; i < 1000; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.out.println("comparedInteger = " + comparedInteger.get());
        System.out.println("stu.score = " + stu.score);


    }
}
