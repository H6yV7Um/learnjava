package com.concurrent.resource;

/**
 * Created by dongchunxu on 2017/7/2.
 */
public class CircularSet {
    private int[] array;
    private int index = 0;
    private int len;

    public CircularSet(int size) {
        array = new int[size];
        this.len = size;
        for (int i = 0; i < size; i++) {
            array[i] = -1;
        }
    }

    public synchronized void add(int i) {
        array[index] = i;
        index = ++index % len;
    }

    public synchronized boolean constains(int val) {
        for (int i= 0; i < len; i++) {
            if (array[i] == val) return true;
        }
        return false;
    }
}
