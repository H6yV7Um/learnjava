package com.pattern.decorator;

/**
 * Created by dongchunxu on 2017/8/2.
 */
public class ConcreteDecoratorB extends Decorator {

    public ConcreteDecoratorB(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        System.out.println("ConcreteDecoratorB pre handle");
        super.operation();
        System.out.println("ConcreteDecoratorB after handle");
    }
}
