package com.pattern.decorator;

/**
 * Created by dongchunxu on 2017/8/2.
 */
public class Main {
    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        Decorator decorator = new ConcreteDecoratorA(component);
        Decorator decorator1 = new ConcreteDecoratorB(decorator);
        decorator1.operation();
    }
}
