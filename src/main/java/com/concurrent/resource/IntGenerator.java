package com.concurrent.resource;

/**
 *
 * Created by dongchunxu on 2017/7/1.
 */
public abstract class IntGenerator {
    private volatile boolean canceld = false;

    public abstract int next();

    public void cancel() {canceld =true;}
    public boolean isCanceld() {return canceld;}
}
