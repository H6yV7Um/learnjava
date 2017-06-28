package com.concurrent.daemon;

import java.util.concurrent.TimeUnit;

/**
 * 后台程序并不是程序中不可或缺的部分
 * 当所有的非后台程序终止时，程序也就终止了，同时会杀死进程中的所有后台线程。
 *
 * Created by dongchunxu on 2017/6/28.
 */
public class SimpleDaemons implements Runnable {
    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException e) {
            System.out.println("sleep() interrupted");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread daemon = new Thread(new SimpleDaemons());
            daemon.setDaemon(true);
            daemon.start();
        }
        System.out.println("all daemons thread started");
        TimeUnit.MILLISECONDS.sleep(175);
    }
}
