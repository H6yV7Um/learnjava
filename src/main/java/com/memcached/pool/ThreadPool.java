package com.memcached.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by dongchunxu on 2017/6/24.
 */
public class ThreadPool {
    ExecutorService service = Executors.newFixedThreadPool(8);

    public void run(Runnable runnable) {
        service.execute(runnable);
    }

}
