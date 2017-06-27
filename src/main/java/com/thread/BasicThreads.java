package com.thread;

/**
 * Created by dongchunxu on 2017/6/28.
 */
public class BasicThreads {
    public static void main(String[] args) {
        Thread t = new Thread(new LiftOff());
        t.start();

        System.out.println("waiting for liftoff.");
    }
}
