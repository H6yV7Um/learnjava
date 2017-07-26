package com.pattern.observable;

/**
 *
 * Created by dongchunxu on 2017/7/20.
 */
public class Observer1 implements Observer{

    private Subject subject;

    public Observer1(Subject subject) {
        this.subject = subject;
    }

    public void notifyDataChanged() {
        System.out.println("Observer1.notifyDataChanged");
    }
}
