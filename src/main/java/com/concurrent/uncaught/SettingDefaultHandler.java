package com.concurrent.uncaught;

import com.concurrent.ExecptionThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by dongchunxu on 2017/6/28.
 */
public class SettingDefaultHandler {
    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());

        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new ExecptionThread());

        exec.shutdown();
    }
}
