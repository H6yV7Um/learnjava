package com.io.input;

import java.io.IOException;
import java.io.StringReader;

/**
 * 从内存中读入并转到控制台
 * Created by dongchunxu on 2017/6/18.
 */
public class MemoryInput {
    public static void main(String[] args) throws IOException {

        StringReader in = new StringReader(BufferdInputFile.read("pom.xml"));
        int c;
        while ((c = in.read()) != -1) {
            System.out.print((char)c);
        }
        in.close();
    }
}
