package com.logging;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * commons-logging 被称为jcl， 对各种日志接口进行抽象.
 * 抽象出一个接口层，对每个日志系统都有适配和转接。
 * 这样这些提供给别人的库都是直接使用抽象层即可，较好的解决了上述问题。
 *
 *
 * 切换日志系统的实现
 * commons-logging.properties
 * org.apache.commons.logging.LogFactory = org.apache.commons.logging.impl.LogFactoryImpl
 *
 * 它是一个抽象层, 默认使用的log4j
 * Created by dongchunxu on 2017/8/6.
 */
public class JCLTest {
    static Log log = LogFactory.getLog(JCLTest.class);
    public static void main(String[] args) {
        String canonicalName = log.getClass().getCanonicalName();
        System.out.println(canonicalName);
    }

}
