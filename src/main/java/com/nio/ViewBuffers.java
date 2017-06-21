package com.nio;

import java.nio.*;

/**
 * 在同一个 ByteBuff 建立多个视图缓冲器
 * Created by dongchunxu on 2017/6/20.
 */
public class ViewBuffers {
    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.wrap(new byte[]{0,0,0,0,0,0,'a',0});

        bb.rewind();

        System.out.println("Byte Buffer  ");
        while (bb.hasRemaining()) {
            System.out.print(bb.position() + ":" + bb.get()+", ");
        }
        System.out.println();

        System.out.println("Char Buffer  ");
        bb.rewind();
        CharBuffer charBuffer = bb.asCharBuffer();
        while (charBuffer.hasRemaining()) {
            System.out.print(charBuffer.position() + ":" + charBuffer.get()+", ");
        }
        System.out.println();
        //错误事例。每次asInBuffer都会返回一个新的视图
//        bb.rewind();
//        while (bb.asIntBuffer().hasRemaining()) {
//            System.out.print(bb.position() + ":" + bb.asIntBuffer().get()+", ");
//        }
//        System.out.println();

        System.out.println("Int Buffer  ");
        bb.rewind();
        IntBuffer intBuffer = bb.asIntBuffer();
        while (intBuffer.hasRemaining()) {
            System.out.print(intBuffer.position() + ":" + intBuffer.get()+", ");
        }
        System.out.println();

        System.out.println("Double Buffer  ");
        DoubleBuffer doubleBuffer = bb.asDoubleBuffer();
        bb.rewind();
        while (doubleBuffer.hasRemaining()) {
            System.out.print(doubleBuffer.position() + ":" + doubleBuffer.get()+", ");
        }
        System.out.println();

        System.out.println("Short Buffer  ");
        ShortBuffer shortBuffer = bb.asShortBuffer();
        bb.rewind();
        while (shortBuffer.hasRemaining()) {
            System.out.print(shortBuffer.position() + ":" + shortBuffer.get()+", ");
        }
        System.out.println();


    }
}
