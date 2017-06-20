package com.io;

import java.io.RandomAccessFile;

/**
 * Created by dongchunxu on 2017/6/18.
 */
public class UsingRandomAccessFile {
    static final String filename = "randomFile.txt";
    public static void display() throws Exception{
        RandomAccessFile raf = new RandomAccessFile(filename, "r");
        for (int i = 0; i < 7; i++) {
            System.out.println("Value " + i + ": " + raf.readDouble());
        }

        System.out.println(raf.readUTF());
        raf.close();
    }

    public static void main(String[] args) throws Exception{
        RandomAccessFile raf = new RandomAccessFile(filename, "rw");
        for (int i = 0; i < 7; i++) {
            raf.writeDouble(i*1.414);
        }
        raf.writeUTF("the end of the file.");
        raf.close();

        display();

        raf = new RandomAccessFile(filename, "rw");
        raf.seek(5*8);
        raf.writeDouble(99.0);
        raf.close();

        display();

    }




}
