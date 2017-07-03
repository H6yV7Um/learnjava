package com.concurrent.interrupt;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 被互斥所阻塞的调用可以被打断
 *
 * lock.lockInterruptibly(); 这里之所以会阻塞，是因为Blocked2 是在主线程创建的
 *
 * Created by dongchunxu on 2017/7/2.
 */
public class Interrupting2 {
    public static void main(String[] args) throws InterruptedException {
        Blocked2 blocked2 = new Blocked2();
        Thread t = new Thread(blocked2);
        t.start();

//        Thread t1 = new Thread(blocked2);
//        t1.start();

        TimeUnit.SECONDS.sleep(1);
        System.out.println("Issuing t.interrupt()");
        t.interrupt();

    }
}

class Blocked2 implements Runnable {
    BlockedMutex blocked = new BlockedMutex();

    public void run() {
        System.out.println("waiting for f() in BlockedMutex");
        blocked.f();
        System.out.println("broken out of blocked call");
    }
}

class BlockedMutex {
    private Lock lock = new ReentrantLock();

    public BlockedMutex() {
        lock.lock();
    }

    public void f() {
        try {
            lock.lockInterruptibly();
            System.out.println("lock acquired in f()");
        } catch (InterruptedException e) {
            System.out.println("interrupted from lock acquisition in f()");
        }
    }
}


