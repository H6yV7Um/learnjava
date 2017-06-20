package com.io.helper;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by dongchunxu on 2017/6/18.
 */
public class TextFile extends ArrayList<String> {

    //read a file as a single string
    public static String read(String filename) {
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


    public static void write(String filename, String text) {
        try {
            PrintWriter out = new PrintWriter(new File(filename).getAbsoluteFile());

            try {
                out.print(text);
            } finally {
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
