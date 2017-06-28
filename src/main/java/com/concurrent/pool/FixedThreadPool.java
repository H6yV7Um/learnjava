package com.concurrent.pool;

import com.concurrent.LiftOff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * newFixedThreadPool 这时候可以一次性预先分配一定数量的线程。
 * 线程可以复用
 *
 * 注意：在任何情况下，现有线程池在可能的情况下都会被复用。 这句话怎么理解？
 * 刚才我们看到newCachedThreadPool提交了50个任务，是真的创建了50个线程。 是否和上述的注意点矛盾。
 * 实际上可能是因为任务的执行速度相对于把任务丢到executor调度器的速度太慢。以至于每次丢进去发现没有可复用的线程，只能重新创建
 * 要想验证这句话的正确性，很简单，只需在for循环里判断一下，当i >= 10 && i % 10 == 0时，每次休眠5秒钟。for的执行次数100，
 * 但最后发现线程数远没有100
 *
 *
 * Created by dongchunxu on 2017/6/28.
 */
public class FixedThreadPool {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            service.execute(new LiftOff());
        }
        service.shutdown();

        System.out.println("观察main线程做了那些事");
    }
}
