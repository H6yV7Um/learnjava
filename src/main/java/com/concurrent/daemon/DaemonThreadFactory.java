package com.concurrent.daemon;

import java.util.concurrent.ThreadFactory;

/**
 * Created by dongchunxu on 2017/6/28.
 */
public class DaemonThreadFactory implements ThreadFactory {

    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setDaemon(true);
        return thread;
    }
}
