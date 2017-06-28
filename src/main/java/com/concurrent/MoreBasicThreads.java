package com.concurrent;

/**
 *
 *  这里有个注意点：
 *  Thread 没有引用指向他，是否会被垃圾回收期回收呢？
 *  答案是不会
 *  每个thread都'注册'了他自己。在他的任务退出其run()并死亡之前。垃圾回收器无法清除它
 *
 * Created by dongchunxu on 2017/6/28.
 */
public class MoreBasicThreads {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new LiftOff()).start();
        }
    }
}
