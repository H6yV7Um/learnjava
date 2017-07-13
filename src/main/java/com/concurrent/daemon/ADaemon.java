package com.concurrent.daemon;

import java.util.concurrent.TimeUnit;

/**
 * 当最后一个非后台线程终止时，后台线程会突然终止。因此main一旦退出，jvm会关闭所有的后台进程。
 * finally 不会被执行
 *
 * Created by dongchunxu on 2017/6/28.
 */
public class ADaemon implements Runnable {
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("exiting InterruptedException");
        } finally {
            System.out.println("this should always run?");
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new ADaemon());
        thread.setDaemon(true);
        thread.start();
    }
}
