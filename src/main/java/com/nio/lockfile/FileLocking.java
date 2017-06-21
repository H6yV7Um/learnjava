package com.nio.lockfile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

/**
 * Created by dongchunxu on 2017/6/21.
 *
 * tryLock 不会阻塞
 * lock 会阻塞
 * 还可以对某个区域加锁.不加参数是对整个文件加锁，即使这个文件后来增大了。
 * 而position+size的形式，即使文件增大加锁的部分也不会增大
 *
 */
public class FileLocking {
    public static void main(String[] args) throws IOException, InterruptedException {
        FileOutputStream fos = new FileOutputStream("file.txt");
        FileLock lock = fos.getChannel().tryLock();
        if (lock != null) {
            System.out.println("Locked file");
            TimeUnit.MILLISECONDS.sleep(10000);
            lock.release();
            System.out.println("Release lock");
        }
        fos.close();
    }
}
