package com.dy.nio;

/**
 * Created by amy on 2017/3/3.
 */
public class Test {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run(){
                while(true){
                    System.out.println("running");
                    //Thread.yield();
                    System.out.println("running");

                }
            }

        });

        thread.yield();
        System.out.println("stop");
    }
}
