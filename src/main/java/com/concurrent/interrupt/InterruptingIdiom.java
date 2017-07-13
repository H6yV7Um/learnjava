package com.concurrent.interrupt;

import java.util.concurrent.TimeUnit;

/**
 * 当你在线程上调用interrupt()时，中断发生的唯一时刻是在任务要进入到阻塞操作中，或者已经在阻塞操作内部时
 * （除了不可中断的io或者被阻塞的synchronized方法之外）
 *
 *
 *  通过检查中断来退出
 *  interrupted() 检查中断状态，不仅可以告诉你interrupt()是否被调用过，而且还可以清除中断状态
 *
 *  这有什么好处？
 *  清除中断状态可以确保并发结构不会就某个任务被中断这个问题通知你两次。
 *
 *
 *  这个例子可以设置不同的时间参数，来观察结果
 *  800, 1200，1010 分别观察结果
 *
 *
 *  1010 时， 程序已经进入到for循环计算中，似乎这里interrupt不能打断？
 *
 * Created by dongchunxu on 2017/7/2.
 */
class NeedsCleanup {
    private final int id;

    public NeedsCleanup(int id) {
        this.id = id;
        System.out.println("NeedsCleanup " + id);
    }

    public void cleanup() {
        System.out.println("Cleaning up " + id);
    }
}

class Blocked3 implements Runnable {
    private volatile double d = 0.0;
    public void run() {
        try {
            while (!Thread.interrupted()) {
                NeedsCleanup n1 = new NeedsCleanup(1);
                try {
                    System.out.println("sleeping.");
                    TimeUnit.SECONDS.sleep(1);

                    NeedsCleanup n2 = new NeedsCleanup(2);
                    try {
                        System.out.println("calculating");
                        for (int i = 0; i < 25000000; i++) {
                            d = d + (Math.PI + Math.E) / d;
                        }
                        System.out.println("finished time - consuming operation");
                    } finally {
                        n2.cleanup();
                    }

                } finally {
                    n1.cleanup();
                }
            }
            System.out.println("Exiting via while() test");
        } catch (InterruptedException e) {
            System.out.println("Exiting via interruptedException");
        }
    }
}

public class InterruptingIdiom {
    public static void main(String[] args) throws InterruptedException {
        if (args.length != 1) {
            System.out.println("usage: java interruptingIdiom delay-in-mS");
            System.exit(1);
        }

        Thread t = new Thread(new Blocked3());
        t.start();

        TimeUnit.MILLISECONDS.sleep(new Integer(args[0]));
        t.interrupt();
    }
}
