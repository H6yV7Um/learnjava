package com.pattern.observable.v2;

/**
 * Created by dongchunxu on 2017/7/20.
 */
public interface Subject {

    void attach(Observer observer);

    void detach(Observer observer);

    void notifyObservers();
}
