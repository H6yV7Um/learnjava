package com.concurrent.resource;

/**
 * Created by dongchunxu on 2017/7/2.
 */
public class SerialNumberGenerator {
    private static volatile int serialNumber = 0;

    public static int nextSerialNumber () {
        return serialNumber++;
    }
}
