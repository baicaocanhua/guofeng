package com.mai.guofeng.learningjava;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author baica
 */
public class MaiBlockingQueue {
    public static void main(String[] args) {
        final BlockingQueue<String> bq = new ArrayBlockingQueue<String>(5);
        Runnable producerRunnable = new Runnable()
        {
            int i = 0;
            public void run()
            {
                while (true)
                {
                    if(i==10){
                        break;
                    }
                    try
                    {
                        int a=i++;
                        System.out.println("我生产了一个" + a);
                        bq.put(a + "");
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        };
        Runnable customerRunnable = new Runnable(){
            public void run()
            {
                while (true)
                {
                    try
                    {
                        System.out.println("我消费了一个" + bq.take());
                        Thread.sleep(3000);
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread producerThread = new Thread(producerRunnable);
        Thread customerThread = new Thread(customerRunnable);
        producerThread.start();
        customerThread.start();
    }
}
