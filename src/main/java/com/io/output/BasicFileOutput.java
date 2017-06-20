package com.io.output;

import java.io.*;

/**
 * PrintWriter 对数据进行格式化
 * Created by dongchunxu on 2017/6/18.
 */
public class BasicFileOutput {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("./src/main/java/com/output/BasicFileOutput.java"));

        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("BasicFileOutput.out")));

        int lineNum = 1;
        String line;
        while ((line = reader.readLine()) != null) {
            writer.println((lineNum++) + line);
        }

        writer.close();
    }
}
