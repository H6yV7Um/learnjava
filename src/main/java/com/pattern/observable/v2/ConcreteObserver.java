package com.pattern.observable.v2;

/**
 *
 * Created by dongchunxu on 2017/7/20.
 */
public class ConcreteObserver implements Observer{

    ConcreteSubject subject;

    public ConcreteObserver(ConcreteSubject subject) {
        this.subject = subject;
    }

    public void notifyDataChanged() {
        System.out.println("ConcreteObserver.notifyDataChanged");
    }

}
