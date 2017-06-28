package com.concurrent;

/**
 * Created by dongchunxu on 2017/6/28.
 */
public class LiftOff implements Runnable {
    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;

    public LiftOff(){}

    public void run() {
        while (countDown-- > 0) {
            System.out.println(status());
            Thread.yield();
        }
    }

    public String status() {
        return "#" + id + "("
                + (countDown > 0 ? countDown + "_threadname:" + Thread.currentThread().getName() : "Liffoff!") + "), ";
    }


}
