package com.concurrent.pool;

/**
 * 1.明明被中断了，isInterrupted打印的是false
 * 当在另外的线程上调用该线程的interrupted方法，会给该线程设置一个标志，表明该线程已经被中断。
 * 然而，异常被捕获时会清理这个标志。所以看到总是false
 *
 * 如果某个线程在另外一个线程t上调用t.join()方法，那么此线程将会被挂起。直到目标线程t执行结束才恢复(isAlive 为false)
 *
 * Created by dongchunxu on 2017/6/28.
 */
public class Joining {
    public static void main(String[] args) {
        Sleeper sleepy = new Sleeper("Sleepy", 1500);
        Sleeper grumpy = new Sleeper("grumpy", 1500);

        Joiner dopey = new Joiner("dopey", sleepy);
        Joiner doc = new Joiner("doc", grumpy);

        grumpy.interrupt();
    }
}

class Sleeper extends Thread {
    private int duration;

    Sleeper(String name, int sleepTime) {
        super(name);
        duration = sleepTime;
        start();
    }

    @Override
    public void run() {
        try {
            sleep(duration);
        } catch (InterruptedException e) {
            System.out.println(getName() + " was interrupted. isInterrupted:" + isInterrupted());
            return;
        }

        System.out.println(getName() + " has awakened");
    }
}

class Joiner extends Thread {
    private Sleeper sleeper;

    Joiner(String name, Sleeper sleeper) {
        super(name);
        this.sleeper = sleeper;
        start();
    }
    @Override
    public void run() {
        try {
            sleeper.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println(getName() + " joined completed");
    }
}