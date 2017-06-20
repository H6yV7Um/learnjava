package com.io.input;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;

/**
 * Created by dongchunxu on 2017/6/18.
 */
public class TestEOF {
    public static void main(String[] args) throws Exception {
        DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("pom.xml")));

        while (in.available() != 0) {//available 代表不阻塞的情况下有多少字节可以读取
            System.out.print((char)in.readByte());
        }

    }
}
