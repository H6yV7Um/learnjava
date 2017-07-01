package com.concurrent.resource;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * Created by dongchunxu on 2017/7/1.
 */
public class EvenChecker implements Runnable {
    private IntGenerator generator;
    private final int id;

    public EvenChecker(IntGenerator generator, int id) {
        this.generator = generator;
        this.id = id;
    }

    public void run() {
        while (!generator.isCanceld()) {
            int val = generator.next();
            if (val % 2 != 0) {
                System.out.println("id: " + id + "," + val + "not even");
                generator.cancel();
            }
//
//            } else {
//                System.out.println("id: " + id + "," +val);
//            }
        }
    }

    public static void test(IntGenerator gp, int count) {
        System.out.println("press control-c to exit.");
        ExecutorService exec = Executors.newCachedThreadPool();

        for (int i = 0; i < count; i++) {
            exec.execute(new EvenChecker(gp, i));
        }
        exec.shutdown();
    }

    public static void test(IntGenerator gp) {
        test(gp, 10);
    }

}
