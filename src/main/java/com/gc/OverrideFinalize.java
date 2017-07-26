package com.gc;

/**
 * Created by dongchunxu on 2017/7/13.
 */
public class OverrideFinalize {
    @Override
    protected void finalize() throws Throwable {

        System.out.println("finalize-----------");
    }

    public static void main(String[] args) throws InterruptedException {
        OverrideFinalize overrideFinalize = new OverrideFinalize();

        System.gc();
        Thread.sleep(10000);
    }
}
