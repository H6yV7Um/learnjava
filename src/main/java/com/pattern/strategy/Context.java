package com.pattern.strategy;

/**
 * Created by dongchunxu on 2017/7/19.
 */
public class Context {

    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }


    public void testStrategyInterface() {
        strategy.strategyInterface();
    }

    public static void main(String[] args) {
        //ConcreteStrategyA concreteStrategyA = new ConcreteStrategyA();
        ConcreteStrategyB concreteStrategyB = new ConcreteStrategyB();
        Context context = new Context(concreteStrategyB);
        context.testStrategyInterface();

    }

}
