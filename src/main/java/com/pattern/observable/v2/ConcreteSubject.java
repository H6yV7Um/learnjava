package com.pattern.observable.v2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dongchunxu on 2017/7/20.
 */
public class ConcreteSubject implements Subject{

    List<Observer> observerList = new ArrayList<Observer>();

    public void attach(Observer observer) {
        observerList.add(observer);
    }

    public void detach(Observer observer) {
        observerList.remove(observer);
    }

    public void notifyObservers() {
        for (int i = 0; i < observerList.size(); i++) {
            observerList.get(i).notifyDataChanged();
        }
    }
}
