package com.io.output;

import com.io.input.BufferdInputFile;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.StringReader;

/**
 * printwriter 的快捷方式版本。
 * 不需要装饰工作,这里仍然是用了缓存
 * Created by dongchunxu on 2017/6/18.
 */
public class FileOutputShortcut {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new StringReader(BufferdInputFile.read("pom.xml")));
        PrintWriter writer = new PrintWriter("FileOutputShortcut.out");
        int linenum = 1;
        String line;
        while ((line = reader.readLine()) != null) {
            writer.println((linenum++) + line);
        }

        writer.close();

    }
}
