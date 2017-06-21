package com.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 *
 * Created by dongchunxu on 2017/6/20.
 */
public class TransferTo {
    public static void main(String[] args) throws IOException {
        FileChannel in = new FileInputStream("TransferTo_from.txt").getChannel();
        FileChannel out = new FileOutputStream("TransferTo_to").getChannel();

        in.transferTo(0, in.size(), out);
    }
}
