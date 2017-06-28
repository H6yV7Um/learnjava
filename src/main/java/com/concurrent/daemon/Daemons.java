package com.concurrent.daemon;

import java.util.concurrent.TimeUnit;

/**
 * 后台线程启动的线程都是后台线程
 * Created by dongchunxu on 2017/6/28.
 */
public class Daemons implements Runnable {
    private Thread[] t = new Thread[10];
    public void run() {
        for (int i = 0; i < t.length; i++) {
            t[i] = new Thread(new DaemonSpawn());
            t[i].start();
            System.out.println("DaemonSpawn " + i + " started, ");
        }

        for (int i = 0; i < t.length; i++) {
            System.out.println("t[ " + i + "] isDaemon? " + t[i].isDaemon());
        }

        while (true) {
            Thread.yield();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Daemons());
        thread.setDaemon(true);
        thread.start();
        System.out.println("thread isDaemon? " + thread.isDaemon());

        TimeUnit.SECONDS.sleep(5);
    }
}

class DaemonSpawn implements Runnable {

    public void run() {
        while (true) {
            Thread.yield();
        }
    }
}
