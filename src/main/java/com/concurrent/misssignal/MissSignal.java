package com.concurrent.misssignal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 两个线程使用notify/wait 协作时，有可能会错误某个信号
 *
 * Created by dongchunxu on 2017/7/12.
 */
public class MissSignal {

    public static void main(String[] args) throws InterruptedException {
        Resource resource = new MissSignal().new Resource();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new TaskA(resource));
        exec.execute(new TaskB(resource));

        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }

    class Resource {
        private volatile boolean flag = true;
        public boolean conditionForTaskB() {
            return flag;
        }

        public void setFlag() {
            flag = false;
        }
    }
}

class TaskA implements Runnable {
    private final MissSignal.Resource resource;

    public TaskA(MissSignal.Resource resource) {
        this.resource = resource;
    }

    public void run() {
        synchronized (resource) {
            System.out.println("TaskA enter synchronized.");
            resource.setFlag();
            System.out.println("TaskA 即将让出cpu.");

            System.out.println("setup condition for TaskB.");
            resource.notify();
            System.out.println("TaskA notify.");
        }
    }
}

class TaskB implements Runnable {
    private final MissSignal.Resource resource;

    public TaskB(MissSignal.Resource resource) {
        this.resource = resource;
    }

    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (resource) {
        while (!resource.conditionForTaskB()) {
            System.out.println("TaskB enter condition");

                System.out.println("TaskB enter synchronized");

                try {
                    resource.wait();
                } catch (InterruptedException e) {
                    System.out.println("Exit InterruptedException B");
                }
            }
        }
        System.out.println("TaskB Exit.");
    }
}

