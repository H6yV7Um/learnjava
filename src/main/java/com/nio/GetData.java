package com.nio;

import java.nio.ByteBuffer;

/**
 * 读取基本数据类型
 * Created by dongchunxu on 2017/6/20.
 */
public class GetData {
    public static final int BSIZE = 1024;
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(BSIZE);

        int i = 0;
        while (i++ < buffer.limit()) {
            if (buffer.get() != 0) {
                System.out.print("nozero");
            }
        }
        System.out.println(i);

        buffer.rewind();
        //存储并且读取一个字符数组
        buffer.asCharBuffer().put("david");
        char c;
        while ((c = buffer.getChar()) != 0) {
            System.out.print(c);
        }
        System.out.println();
        //short 因为要截取，所以数字可能不对,当范围超过short的时候
        buffer.rewind();
        buffer.asShortBuffer().put((short)1000002);
        System.out.print(buffer.getShort());
        System.out.println();

        buffer.rewind();
        buffer.asIntBuffer().put(1000002);
        System.out.print(buffer.getInt());
        System.out.println();

        //long float double 跟上面类似

    }
}
