package com.concurrent.waxomatic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 之前关注的问题是任务之间如何同步， 现在是如何协作？
 * 某些部分必须在其他部分被解决之前解决
 *
 *  wait()使你可以等待某个条件发生变化, 而改变这个条件超过了当前方法的控制能力。
 * 通常，这由另外一个任务来改变。 你肯定不希望你的任务测试这个条件的同时，不断的进行空循环（忙等待）
 * 因此，wait会在等待外部世界产生变化的时候将任务挂起。并且只有在notify()发生时，即表示发生了某些感兴趣的事务，
 * 这个任务才会被唤醒并去检查产生的变化。因此wait()提供了一种在任务之间对活动同步的方式
 *
 * 1.wait 期间锁是释放的。
 * 2.可以通过notify(), notifyAll()或者时间到期，从wait()恢复执行
 *
 * 注意： 在调用wait， notify， notifyall这些操作时，必须拥有对象的锁
 *
 *
 * while()
 * 本质上是，检查所感兴趣的特定条件, 并在条件不满的情况下返回到wait() 中。
 *
 * Created by dongchunxu on 2017/7/9.
 */

class Car {
    private boolean waxOn = false;

    /** 打纳 */
    public synchronized void waxed() {
        waxOn = true;   //ready to buff
        notifyAll();
    }

    /** 抛光 */
    public synchronized void buffed() {
        waxOn = false;  //ready for anthor cost of wax
        notifyAll();
    }

    public synchronized void waitForWaxing() throws InterruptedException {
        while (!waxOn) {
            wait();
        }
    }

    public synchronized void  waitForBuffing() throws InterruptedException {
        while (waxOn) {
            wait();
        }
    }
}

class WaxOn implements Runnable {
    private Car car;

    public WaxOn(Car car) {
        this.car = car;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println("Wax on! ");
                TimeUnit.MILLISECONDS.sleep(200);

                car.waxed();
                car.waitForBuffing();
            }
        } catch (InterruptedException e) {
            System.out.println("Exiting via interrupt.");
        }
        System.out.println("Ending Wax On task");
    }
}


class WaxOff implements Runnable{
    private Car car;

    public WaxOff(Car car) {
        this.car = car;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                car.waitForWaxing();
                System.out.println("Wax off.");

                TimeUnit.MILLISECONDS.sleep(200);
                car.buffed();
            }
        } catch (InterruptedException e) {
            System.out.println("Exiting via interrupt.");
        }
        System.out.println("Ending Wax Off task");
    }
}

public class WaxOMatic {

    public static void main(String[] args) throws InterruptedException {
        Car car = new Car();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new WaxOff(car));
        exec.execute(new WaxOn(car));

        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }
}


