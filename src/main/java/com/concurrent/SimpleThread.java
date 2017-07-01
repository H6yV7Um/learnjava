package com.concurrent;

/**
 * start()方法在构造器中调用会带来意外的风险。
 * 因为此时另外一个任务可能在构造器结束之前开始执行，这意味着该任务能够访问处于不稳定状态的对象
 *
 * Created by dongchunxu on 2017/6/28.
 */
public class SimpleThread extends Thread {
    private int countDown = 5;
    private static int threadCount = 0;

    public SimpleThread() {
        super(Integer.toString(threadCount++));
        start();
    }

    public String toString() {
        return "#" + getName() + "(" + countDown + ").";
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(this);
            if (--countDown == 0) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new SimpleThread();
        }
    }
}
