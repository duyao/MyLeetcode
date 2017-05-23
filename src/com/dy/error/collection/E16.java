package com.dy.error.collection;

/**
 * Created by amy on 2017/2/20.
 */
public class E16 {
    public static void main(String[] args) {

        Thread t = new Thread() {
            public void run() {
                pong();
            }
        };
        //run并不是表示开始新的线程，因此按照程序的执行顺序调用
        //所以结果为pongping
        t.run();
        //表示新的线程开始执行，该线程得到时间片就可以执行这个方法，因此结果不确定？还是pingpong呢？
        t.start();
        System.out.print("ping");

    }

    static void pong() {
        System.out.print("pong");
    }

}
