package com.concurrent;

/**
 * Created by dongchunxu on 2017/6/28.
 */
public class MainThread {
    public static void main(String[] args) {
        LiftOff liftOff = new LiftOff();
        liftOff.run();
    }
}
