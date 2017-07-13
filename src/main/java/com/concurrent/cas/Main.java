package com.concurrent.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS compare and set
 * 乐观锁用的机制就是CAS
 * CAS 涉及到到三个值current, next, 以及当前内存中的值
 * 1. 拿到内存中的值 current = a
 * 2. 计算一个想要更新的值 比如next = current + 1
 * 3. 当且仅当current 和 内存中的最新值相同时，才会做更新操作。否则重复步骤一
 *
 *
 * ABA 问题
 * 一个进程p1 读到共享变量A
 * p1被抢占，进程p2执行
 * p2把共享变量里的值从A改回B,再改回A, 此时p1 抢占到cpu，开始执行
 * p1看到这个值还是A, 所以继续执行
 *
 * Created by dongchunxu on 2017/7/11.
 */
public class Main {
    private final static AtomicInteger atomicInteger = new AtomicInteger(1);

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            int previous = atomicInteger.getAndIncrement();
            System.out.println(previous);
        }
    }
}
