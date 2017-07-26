package com.pattern.observable;

/**
 *
 * Created by dongchunxu on 2017/7/20.
 */
public class Observer2 implements Observer {
    public Observer2() {
    }

    public void notifyDataChanged() {
        System.out.println("Observer2.notifyDataChanged");
    }
}
