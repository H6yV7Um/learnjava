package com.nio;


import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by dongchunxu on 2017/6/19.
 */
public class GetChannel {
    private static final int BSIZE = 1024;

    public static void main(String[] args) throws IOException {
        FileChannel fc =
                new FileOutputStream("data.txt").getChannel();
        fc.write(ByteBuffer.wrap("dongchunxu".getBytes()));
        fc.close();

        fc = new RandomAccessFile("data.txt","rw").getChannel();
        fc.position(fc.size());
        fc.write(ByteBuffer.wrap("APPEN a line".getBytes()));
        fc.close();

        //read the file
        fc = new FileInputStream("data.txt").getChannel();
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        fc.read(buff);

        buff.flip();
        while (buff.hasRemaining()) {
            System.out.println((char)buff.get());
        }
    }
}
