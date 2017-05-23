package com.dy.java.core;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by amy on 2017/5/23.
 */
public class MultiThread {
    enum Work {
        RUN, STOP
    }

    static class Worker implements Runnable {

        private BlockingQueue<Work> in;
        private BlockingQueue<Work> out;

        public Worker(BlockingQueue<Work> in, BlockingQueue<Work> out) {
            this.in = in;
            this.out = out;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Work w = in.take();
                    if (w == Work.RUN) {
                        for (int i = 0; i < 10; ++i)
                            System.out.println("worker " + i);
                    }
                    out.put(w);
                    if (w == Work.STOP) {
                        return;
                    }
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {

        BlockingQueue<Work> in = new ArrayBlockingQueue<>(1);
        BlockingQueue<Work> out = new ArrayBlockingQueue<>(1);
        Worker w = new Worker(in, out);
        Thread t = new Thread(w);
        t.start();
        try {
            for (int round = 0; round < 5; ++round) {
                System.out.println("round " + round);
                in.put(Work.RUN);
                out.take();
                for (int i = 0; i < 15; ++i)
                    System.out.println("main " + i);
            }
            in.put(Work.STOP);
            t.join();
        } catch (InterruptedException e) {
        }
    }
}
