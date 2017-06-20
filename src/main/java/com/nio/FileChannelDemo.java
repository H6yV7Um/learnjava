package com.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dongchunxu on 2017/5/13.
 */
public class FileChannelDemo {
    public static void main(String[] args) throws IOException {

//        testRandomAccessFile();

//        boolean direct = buffer.isDirect();
//        System.out.println(direct);
//
//        try {
//            testMapping();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("orderId", 12313L);
        param.put("categoru", "asdada");
        if ((Long)param.get("orderId") == 12313L) {
            System.out.println("hh");
        }

        System.out.println(param);
    }


    static void testMapping() throws IOException {
        RandomAccessFile raf = new RandomAccessFile("random.txt", "rw");
        FileChannel fileChannel = raf.getChannel();

        MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, 20);
        System.out.println("is direct:" + mappedByteBuffer.isDirect());
        System.out.println("char:" + (char)mappedByteBuffer.get(14));

        mappedByteBuffer.putChar(0, 'z');
    }



    static void testRandomAccessFile() throws IOException {
        RandomAccessFile raf = new RandomAccessFile("random.txt", "rw");
        FileChannel channel = raf.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int bytesRead = channel.read(buffer);
        while (bytesRead != -1) {
            System.out.println("read bytes: " + bytesRead);
            buffer.flip();

            while (buffer.hasRemaining()) {
                System.out.println("char: " + (char)buffer.get());
            }
            buffer.clear();
            bytesRead = channel.read(buffer);
        }

        raf.close();
    }






}
