package com.concurrent.resource;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 *  1.volatile 会保证long,double变量的可视性(简单的赋值和返回操作)
 *  因为jvm会将64位的long,double变量的读取和写入当做两个分离的32位操作来执行。
 *  2.volatile还保证了可视性 只要对这个域产生了写操作，那么所有的读取操作都可以看到这个修改
 *  即便使用了本地缓存，情况也确实如此，volatile域会被理解写入到主存中，而读取操作就发生在主存中
 *
 *  同步也会导致向主存中刷新
 *
 * Created by dongchunxu on 2017/7/2.
 */
public class AttemptLocking {
    private ReentrantLock lock = new ReentrantLock();

    void untimed() {
        boolean captured = lock.tryLock();
        try {
            System.out.println("try lock(): " + captured);
        } finally {
            if (captured) {
                lock.unlock();
            }
        }
    }

    void timed() {
        boolean captured = false;
        try {
            captured = lock.tryLock(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println("try lock(2, TimeUnits.SECONDS): " + captured);
        } finally {
            if (captured) {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        final AttemptLocking al = new AttemptLocking();
        al.untimed();
        al.timed();

        new Thread() {
            {setDaemon(true);}

            @Override
            public void run() {
                al.lock.lock();
                System.out.println("acquired.");
            }
        }.start();

        Thread.yield();

        al.untimed();
        al.timed();
    }
}
