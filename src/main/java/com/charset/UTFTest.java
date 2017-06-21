package com.charset;

import java.io.UnsupportedEncodingException;

/**
 * UTF-8 UTF-16 UTF-32
 * 代码单元
 * 代码单元指一种转换格式（UTF）中最小的一个分隔
 * 8,16,32就是指各自代码单元的位数
 *
 * string.length 显示的是字符串中的Unicode代码单元的数目
 * Java语言里String在内存中以是UTF-16方式编码的
 * 𧿹 这个字不在bmp里，所以长度为2，即4个字节
 *
 *
 * Created by dongchunxu on 2017/6/21.
 */
public class UTFTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        System.out.println("𧿹".length());
        System.out.println("虎".length());

        testGetByetsMethod();
    }

    /**
     * GBK是变长编码，对ASCII字符采用一字节，汉字则是两字节
     *
     * string.getBytes不过是把一种编码的字节数组转换成另一种编码的字节数组。
     * 这里的一种编码在Java中就是UTF-16，这个已经定了，你不用操心，你也改不了！
     * 这里的另一种编码则由你来指定，不指定就用缺省
     *
     * */
    public static void testGetByetsMethod() throws UnsupportedEncodingException {
        String text = "hello你好";
        /*
         * String 在内存中是以UTF-16编码，是不是指它用UTF-16编码时所用的字节呢？答案是否定的
         * 那是不是是跟操作系统的编码一致呢？ 也不是。
         * string.getBytes在没有指定参数的时候，它使用了JVM的缺省编码，
         * 如果启动JVM时没有明确设置编码，那么JVM就会使用所在操作系统的缺省编码；
         * 但如果启动时明确地设置了编码，那么这一设置将成为JVM中的缺省编码！
         *
         *
         *  */
        System.out.println("default charset encoded length: " + text.getBytes().length);
        System.out.println("GBK charset encoded length: " + text.getBytes("GBK").length);
        System.out.println("UTF-16 charset encoded length: " + text.getBytes("UTF-16").length); //多出的两个字节是BOM

        for (byte b : text.getBytes("UTF-16")) {
            System.out.print(Integer.toHexString(b));
        }


    }
}
