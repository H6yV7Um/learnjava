package com.io.input;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

/**
 * Created by dongchunxu on 2017/6/18.
 */
public class FormattedMermoryInput {
    public static void main(String[] args) throws IOException {
        DataInputStream in;
        in = new DataInputStream(new ByteArrayInputStream(BufferdInputFile.read("pom.xml").getBytes()));

        while (true) {
            System.out.print((char)in.readByte());
        } //这个读不到数据会报异常
        //为什么不能用判断-1 来判断是否已经达到文件结尾。因为读的byte，任何值都是有可能的
    }
}
