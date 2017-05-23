package com.dy.concurrent;

import org.omg.CORBA.PRIVATE_MEMBER;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * Created by amy on 2017/3/4.
 */
public class ForkJoinDemo extends RecursiveTask<Long> {
    private static final int THREADHOLD = 10000;
    private long start;
    private long end;

    public ForkJoinDemo(long start, long end) {
        this.start = start;
        this.end = end;
    }


    @Override
    protected Long compute() {
        long sum = 0;
        boolean canCompute = (end - start) < THREADHOLD;
        //分为可以执行和不能执行
        if (canCompute) {
            for (long i = start; i < end; i++) {
                sum += i;
            }
        } else {
            //分成100个小任务
            long step = (start + end) / 100;
            ArrayList<ForkJoinDemo> subTasks = new ArrayList<>();
            long pos = start;
            for (int i = 0; i < 100; i++) {
                long lastOne = pos + step;
                //最后一个任务不够100
                if (lastOne > end) {
                    lastOne = end;
                }
                ForkJoinDemo subTask = new ForkJoinDemo(pos, lastOne);
                pos += step+1;
                subTasks.add(subTask);
                //提交到大任务
                subTask.fork();
            }
            for (ForkJoinDemo t : subTasks) {
                //等待
                sum += t.join();
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinDemo task = new ForkJoinDemo(0, 200000L);

        ForkJoinTask<Long> result = forkJoinPool.submit(task);
        try {
            //会抛出异常
            long res = result.get();
            System.out.println("sum = " + res);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
