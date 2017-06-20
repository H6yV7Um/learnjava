package com.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by dongchunxu on 2017/6/20.
 */
public class ChannelCopy {
    private static final int BSIZE = 10;


    public static void main(String[] args) throws Exception {
        FileChannel in = new FileInputStream("from.txt").getChannel();
        FileChannel out = new FileOutputStream("to.txt").getChannel();

        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        while (in.read(buff) != -1) {
            buff.flip();
            out.write(buff);
            buff.clear();
        }
    }
}
