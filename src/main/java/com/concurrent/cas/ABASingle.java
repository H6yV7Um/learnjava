package com.concurrent.cas;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * Created by dongchunxu on 2017/7/11.
 */
public class ABASingle {
    private static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<Integer>(100, 0);


    public static void main(String[] args) {
//        AtomicInteger atomicInt = new AtomicInteger(100);
//        atomicInt.compareAndSet(100, 101);
//        atomicInt.compareAndSet(101, 100);
//        System.out.println("new value= " + atomicInt.get());
//
//        boolean result1 = atomicInt.compareAndSet(100, 101);
//        System.out.println("result1: " + result1);
//
//        AtomicInteger v1 = new AtomicInteger(100);
//        AtomicInteger v2 = new AtomicInteger(100);
//        AtomicStampedReference<AtomicInteger> stampedRef = new AtomicStampedReference<AtomicInteger>(v1, 0);
//
//        int stamp = stampedRef.getStamp();
//        System.out.println("stamp: " + stamp);
//        stampedRef.compareAndSet(v1, v2, stampedRef.getStamp(), stampedRef.getStamp()+ 1);
//        stampedRef.compareAndSet(v2, v1, stampedRef.getStamp(), stampedRef.getStamp()+ 1);
//
//        System.out.println("new value= " + stampedRef.getReference());
//
//
//        boolean result2 = stampedRef.compareAndSet(v1, v2, stamp, stamp+ 1);
//        System.out.println("result2: " + result2);
//

        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Task1());
        exec.execute(new Task2());
    }

    static class Task1 implements Runnable {

        public void run() {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            atomicStampedReference.compareAndSet(100, 101,
                    atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);

            boolean b = atomicStampedReference.compareAndSet(101, 102,
                    atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);

            System.out.println("Task1 result : "  + b + ", stamp: " + atomicStampedReference.getStamp()
                + ",reference: " + atomicStampedReference.getReference());
        }
    }


    static class Task2 implements Runnable {

        public void run() {
            int stamp = atomicStampedReference.getStamp();

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            boolean b = atomicStampedReference.compareAndSet(100, 101, stamp, stamp + 1);
            System.out.println("Task2 result: " + b);
        }
    }
}
