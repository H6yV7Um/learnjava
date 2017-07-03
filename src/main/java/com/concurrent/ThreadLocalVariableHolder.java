package com.concurrent;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by dongchunxu on 2017/7/2.
 */
public class ThreadLocalVariableHolder {
    private static ThreadLocal<Integer> value = new ThreadLocal<Integer>() {
        private Random random = new Random(47);
        @Override
        protected Integer initialValue() {
            return random.nextInt(10000);
        }
    };


    static class Accessor implements Runnable {
        private final int id;

        public Accessor(int id) {
            this.id = id;
        }

        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                ThreadLocalVariableHolder.increment();
                System.out.println(this);
                Thread.yield();
            }
        }

        @Override
        public String toString() {
            return "#" + id + ": " + ThreadLocalVariableHolder.get();
        }
    }

    private static void increment() {
        value.set(value.get() + 1);
    }

    public static int get() {
        return value.get();
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new Accessor(i));
        }
        TimeUnit.SECONDS.sleep(3);
        exec.shutdown();
    }
}
