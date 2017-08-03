package com.pattern.decorator;

/**
 * Created by dongchunxu on 2017/8/2.
 */
public abstract class Decorator extends Component{
    Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        component.operation();
    }
}
