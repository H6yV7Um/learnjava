package com.pattern.decorator;

/**
 * Created by dongchunxu on 2017/8/2.
 */
public class ConcreteDecoratorA extends Decorator {
    public ConcreteDecoratorA(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        System.out.println("ConcreteDecoratorA pre handle");
        super.operation();
        System.out.println("ConcreteDecoratorA after handle");
    }
}
