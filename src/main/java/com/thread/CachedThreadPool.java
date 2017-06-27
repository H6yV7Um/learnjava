package com.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * shutdown()只是不再接受新的任务.并且这个程序将在Executor中的所有任务完成之后尽快退出
 * 如果注释掉shutdown(),当前main方法不可以往下执行，即最后那句话打印不了，程序暂时也无法退出。似乎这个ExecutorService
 * 还在等待任务提交给它执行。但是过了一会儿程序又退出了
 *
 * 根据打印的线程名可以看出，newCachedThreadPool是提交了多少任务就创建多少线程. 是否正确？
 *
 * 推荐首选这种方式
 *
 * Created by dongchunxu on 2017/6/28.
 */
public class CachedThreadPool {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            service.execute(new LiftOff());
            if (i >= 10 && i % 10 == 0) {
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        service.shutdown();

        System.out.println("观察main线程做了那些事");
    }
}
