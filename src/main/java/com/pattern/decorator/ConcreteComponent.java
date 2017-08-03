package com.pattern.decorator;

/**
 * Created by dongchunxu on 2017/8/2.
 */
public class ConcreteComponent extends Component {

    @Override
    public void operation() {
        System.out.println("ConcreteComponent do something.");
    }
}
