package com.logging;

import org.apache.log4j.Logger;

/**
 * log4j 最早的java日志处理系统，比java官方出来的还要早
 * 需要classpath 下新建一个log4j.properties
 *
 * Created by dongchunxu on 2017/8/6.
 */
public class Log4jTest {
    static Logger log = Logger.getLogger(Log4jTest.class);
    public static void main(String[] args) {
        log.info("hello,world");

        try {
            testException();
        } catch (Throwable e) {
            log.error(e);
        }

        /**
         * 已经看出来，这是两种风格的日志系统
         *
         * */

        JULTest.usingJavaSlefLoggingSystem();
    }


    public static void testException() {
        throw new RuntimeException("this is a exception.");
    }
}
