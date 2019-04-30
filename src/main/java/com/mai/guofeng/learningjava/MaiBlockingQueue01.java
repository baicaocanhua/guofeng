package com.mai.guofeng.learningjava;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MaiBlockingQueue01 {
    public static void main(String[] args) {

        final BlockingQueue<String> bq = new ArrayBlockingQueue<String>(5);

        Runnable producerRunnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        bq.put(i + "");
                        //Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Runnable customerRunnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    String ss = null;


                    ss = bq.poll();


                    System.out.println(ss);
                }
            }
        };


        Thread producerThread = new Thread(producerRunnable);
        Thread customerThread = new Thread(customerRunnable);
        producerThread.start();
        customerThread.start();


    }
}
