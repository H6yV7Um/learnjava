package com.logging;

import org.slf4j.bridge.SLF4JBridgeHandler;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 测试的是java自带的日志系统
 * Created by dongchunxu on 2017/8/6.
 */
public class JULTest {
    private static Logger logger = Logger.getLogger(JULTest.class.getName());
    public static void main(String[] args) {

       usingJavaSlefLoggingSystem();
    }

    public static void usingJavaSlefLoggingSystem() {
        try {
            throw new RuntimeException("this is a exception.");
        } catch (Throwable e) {
            logger.log(Level.WARNING, "this is a exception", e);
        }

        logger.info("test logger.info()");
    }
}
