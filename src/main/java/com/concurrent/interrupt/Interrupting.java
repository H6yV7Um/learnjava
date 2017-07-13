package com.concurrent.interrupt;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @see OrnamentalGarden 使程序员写标志位是判断是否应该终止任务
 * 下面是演示如何打断在阻塞状态下的任务
 *
 * 1. 调用interrupt，必须持有Thread对象，而新的类库却推荐使用Executor来执行所有操作。
 * 关闭所有任务：如果在Executor上调用shutdownNow，它将会发送一个interrupt调用给它启动的所有线程。
 * 关闭单个任务： 通过submit提交任务就可以获得任务的上下文Future。来调用cancel方法，调用cancel(true)和执行，那么它就拥有在
 *  该线程上调用interrupt的权限。
 *
 *  在io和synchronized块上的阻塞不可中断
 *  如何解决？
 *  @see CloseResource
 *
 * Created by dongchunxu on 2017/7/2.
 */
public class Interrupting {
    private static ExecutorService exec = Executors.newCachedThreadPool();
    static void test(Runnable r) throws InterruptedException {
        Future<?> f = exec.submit(r);
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("Interrupting " + r.getClass().getName());
        f.cancel(true);
        System.out.println("interrupt sent to " + r.getClass().getName());

    }

    public static void main(String[] args) throws InterruptedException {
        test(new SleepBlocked());
        test(new IOBlocked(System.in));
        test(new SynchronizedBlocked());


        TimeUnit.SECONDS.sleep(3);
        System.out.println("Aborting with Sys.exit(0)");
        System.exit(0);
    }
}

class SleepBlocked implements Runnable {
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        }
        System.out.println("Exiting SleepBlocked.run()");
    }
}


class IOBlocked implements Runnable {
    private InputStream in;

    public IOBlocked(InputStream in) {
        this.in = in;
    }

    public void run() {
        try {
            System.out.println("Waiting for read();");
            int read = in.read();
            System.out.println(read);
        } catch (IOException e) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Interrupted from block I/O.");
            } else {
                throw new RuntimeException(e);
            }
            System.out.println("Exiting IOBlocked.run()");
        }
    }
}


class SynchronizedBlocked implements Runnable {

    public synchronized void f() {
        while (true) {
            Thread.yield();
        }
    }

    public SynchronizedBlocked() {
        new Thread(){
            @Override
            public void run() {
                f();
            }
        }.start();
    }

    public void run() {
        System.out.println("trying to call f()");
        f();
        System.out.println("Exiting synchronedBlocked.run()");
    }
}




