package com.concurrent.resource;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by dongchunxu on 2017/7/2.
 */
public class SerialNumberChecker {
    private static final int SIZE = 10;
    private static CircularSet serials =
            new CircularSet(1000);

    private static ExecutorService exec = Executors.newCachedThreadPool();



    static class SerialChecker implements Runnable {

        public void run() {
            while (true) {
                int serialNum = SerialNumberGenerator.nextSerialNumber();
                if (serials.constains(serialNum)) {
                    System.out.println("duplicate num:" + serialNum);
                    System.exit(0);
                }
                serials.add(serialNum);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < SIZE; i++ ) {
            exec.execute(new SerialChecker());
        }

        if (args.length > 0) {
            TimeUnit.SECONDS.sleep(4);
            System.out.println("NO DUPLICATE ");
            System.exit(0);
        }

    }
}
