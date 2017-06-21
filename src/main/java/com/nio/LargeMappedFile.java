package com.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * MappedByteBuffer 是映射在内存地址空间上的。实际上并没有载入内存。当写入或读取内容时，都是发出一个缺页中断。由操作系统去响应。
 * 然后调入内存或者写入磁盘。所以他可以写入/读取很大的文件
 *
 * Created by dongchunxu on 2017/6/21.
 */
public class LargeMappedFile {
    static int length = 0xfffffff;  //128MB
    public static void main(String[] args) throws IOException {
        MappedByteBuffer mbb =
                new RandomAccessFile("LargeMappedFile.txt", "rw")
                        .getChannel()
                .map(FileChannel.MapMode.READ_WRITE, 0, length);
        for (int i = 0; i < length; i++) {
            mbb.put((byte)'x');
        }
        System.out.println("Finished writing");

        for (int i = length / 2; i < length / 2 + 6; i++) {
            System.out.print((char)mbb.get(i));
        }

    }
}
