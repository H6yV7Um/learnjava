package com.io.input;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * 根据filename或者File 读取一个文件，并输出
 * Created by dongchunxu on 2017/6/18.
 */
public class BufferdInputFile {

    public static String read(String filename) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(filename));

        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = in.readLine()) != null) {
            sb.append(line + "\n");
        }

        in.close();
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        String content = read("pom.xml");
        System.out.println(content);
    }
}
