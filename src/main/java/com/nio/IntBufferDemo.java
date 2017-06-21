package com.nio;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * 这里flip 一次只读了一个数据，然后写了一个数据。这时候如果虽然数据没有读完再次读取的也要rewind
 * 有空看看ByteBuff的源码
 *
 * Created by dongchunxu on 2017/6/20.
 */
public class IntBufferDemo {
    private static final int BSIZE = 1024;
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(BSIZE);

        IntBuffer ib = buffer.asIntBuffer();
        ib.put(new int[]{10,11,22,33,44,55});

        ib.flip();
        System.out.println(ib.get(3));

        ib.put(3, 1000);

        ib.rewind();
        while (ib.hasRemaining()) {
            System.out.println(ib.get());
        }
    }
}
