package com.concurrent.resource;

/**
 * 下面这个例子不是线程安全的
 * 基本上所有的并发模式在解决线程冲突问题的时候，都是采用序列化访问共享资源的方案。
 * 可以通过互斥量mutex的机制
 *
 * 所有对象当自动含有单一的锁
 * Created by dongchunxu on 2017/7/1.
 */
public class EvenGenerator extends IntGenerator {
    private int currentEventVal = 0;
    //private AtomicInteger atomicInteger;

    private final Object obj = new Object();

    public int next() {
        synchronized (obj) {
//            atomicInteger.addAndGet(1);
//            atomicInteger.addAndGet(1);
            ++currentEventVal;
            ++currentEventVal;
            return currentEventVal;
        }
    }

    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator());
    }
}
