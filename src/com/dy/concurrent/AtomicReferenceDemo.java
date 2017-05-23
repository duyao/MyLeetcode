package com.dy.concurrent;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by think on 2017-03-04.
 */
public class AtomicReferenceDemo {
    public static void main(String[] args) {

        AtomicReference<String> string = new AtomicReference<>("abc");

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    if (string.compareAndSet("abc", "def")) {
                        System.out.println(Thread.currentThread().getId() + "changed");

                    } else {
                        System.out.println(Thread.currentThread().getId() + "failed");
                    }

                }
            }).start();

        }


    }
}
