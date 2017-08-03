package com.utils;

import java.io.*;

/**
 * Created by dongchunxu on 2017/8/2.
 */
public class TextFile {
    public static String readFile(String filename) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(filename).getAbsoluteFile()));

            try {
                String s;
                while ((s = reader.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            } finally {
                reader.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }
}
