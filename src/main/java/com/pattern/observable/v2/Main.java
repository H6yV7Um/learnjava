package com.pattern.observable.v2;

/**
 *
 * Created by dongchunxu on 2017/7/20.
 */
public class Main {

    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        Observer observer = new ConcreteObserver(subject);
        subject.attach(observer);
        subject.notifyObservers();
    }
}
