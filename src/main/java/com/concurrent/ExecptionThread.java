package com.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * run方法中的异常逃逸到外部线程。 注意，即使把main放在try-catch里也是没有用的，捕获不到
 *
 * Created by dongchunxu on 2017/6/28.
 */
public class ExecptionThread implements Runnable {

    public void run() {
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new ExecptionThread());
        while (true) {
            System.out.println("------");
        }
    }
}
