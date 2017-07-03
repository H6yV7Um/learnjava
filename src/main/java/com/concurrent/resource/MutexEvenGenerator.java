package com.concurrent.resource;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock 需要显示的加锁和释放。所以使用起来没有synchronzied优雅。
 * 但是有的时候使用起来更加的灵活
 * 而且当加锁失败时，你有机会去做一些清理工作
 *
 *
 * Created by dongchunxu on 2017/7/2.
 */
public class MutexEvenGenerator extends IntGenerator {

    private int currentEventValue = 0;
    private Lock lock = new ReentrantLock();

    public int next() {
        lock.lock();
        try {
            ++currentEventValue;
            Thread.yield();
            ++currentEventValue;
            return currentEventValue;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        EvenChecker.test(new MutexEvenGenerator());
    }
}
