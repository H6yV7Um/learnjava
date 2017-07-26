package com.pattern.observable;

/**
 * Created by dongchunxu on 2017/7/20.
 */
public class Main {
    public static void main(String[] args) {
        Subject subject  = new Subject();
        subject.attach(new Observer1(subject));
        subject.attach(new Observer2());
        subject.notifyObservers();
    }
}
