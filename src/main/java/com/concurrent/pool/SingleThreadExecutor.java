package com.concurrent.pool;

import com.concurrent.LiftOff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * newSingleThreadExecutor 相当于是数量为1的newFixedThreadPool
 * 它自己会维护一个队列，按照任务的提交顺序，一个个顺序执行
 *git
 * Created by dongchunxu on 2017/6/28.
 */
public class SingleThreadExecutor {
    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 1000; i++) {
            service.execute(new LiftOff());
        }
        service.shutdown();
        System.out.println("观察main线程做了那些事");
    }
}
