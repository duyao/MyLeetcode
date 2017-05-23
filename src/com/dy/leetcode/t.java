package com.dy.leetcode;

import java.util.concurrent.*;

/**
 * Created by amy on 2017/3/24.
 */
class Task {
    public void fun() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " 执行 - " + i);
        }
    }
}
public class t {
    public static void main(String[] args) {
        final Task task = new Task();
        ThreadPoolExecutor pool =
                new ThreadPoolExecutor(2, 3, 3L,
                        TimeUnit.SECONDS, new SynchronousQueue<Runnable>(), new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 4; i++) {
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    task.fun();
                    System.out.println("run");
                }
            });
        }
        pool.shutdown();
    }
}
