package com.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * 不想每次只读一个字节，然后把字节转为字符
 * 可以用asCharBuffer方法.但是要注意编码
 *
 * 虽然FileInputStream, FileOutputStream, RandomAccessFile都有getChannel方法
 * 而FileChannel 的position的方法只有是RandomAccessFile得到的才有效
 *
 * 1.bytebuff.put 写的时候如果字符数大于bytebuff 的容量时会报错的
 * 2.写入这个文件的时候是以UTF-17BE格式写进去的。下面读的时候没有任何形式指定编码。为什么能正常读出来？我的理解是这里会乱码。因为默认编码是UTF-8，你写进去是UTF-16BE
 * 3.第三个例子可以理解子asCharBuffer 以字符视图写入，再以字符视图读出
 * 4.Charset有编码解码的功能
 *
 * Created by dongchunxu on 2017/6/20.
 */
public class BufferToText {
    private static final int BSIZE = 1024;

    public static void main(String[] args)throws Exception {
        FileChannel fc =
                new FileOutputStream("BufferToText.txt").getChannel();
        fc.write(ByteBuffer.wrap("write some words".getBytes()));
        fc.close();

        fc = new FileInputStream("BufferToText.txt").getChannel();
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        fc.read(buff);

        buff.flip();
        //不会正则工作
        System.out.println(buff.asCharBuffer());

        //用本机默认编码UTF-8解码就能得到正确的结果
        buff.rewind();
        String encoding = System.getProperty("file.encoding");
        System.out.println("decoded using " + encoding
            + ", " + Charset.forName(encoding).decode(buff));

        fc = new RandomAccessFile("BufferToText.txt", "rw").getChannel();
        fc.position(fc.size());
        fc.write(ByteBuffer.wrap("some text encode as utf16e".getBytes("UTF-16BE")));
        fc.close();

        //这里再读出来。就不乱码了
        fc = new FileInputStream("BufferToText.txt").getChannel();
        buff.clear();
        fc.read(buff);

        buff.flip();
        System.out.println(buff.asCharBuffer());


        //3.直接用charbuffer写
        fc = new FileOutputStream("BufferToText.txt").getChannel();
        buff = ByteBuffer.allocate(18);
        buff.asCharBuffer().put("some test");
        fc.write(buff);
        fc.close();


        //再去读
        fc = new FileInputStream("BufferToText.txt").getChannel();
        buff.clear();
        fc.read(buff);
        buff.flip();
        System.out.println(buff.asCharBuffer());


    }
}
