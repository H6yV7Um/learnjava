package com.nio;

import java.io.*;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;

/**
 * 测试流读写和映射内存的读写方式的性能差异
 *
 * 映射文件输出必须使用RandomAccessFile，使用FileOutputStream没用
 *
 * Created by dongchunxu on 2017/6/21.
 */
public class MappedIO {
    private static int numOfInts = 4000000;
    private static int numOfUbuffInts = 200000;

    private abstract static class Tester {
        private String name;

        public Tester(String name) {
            this.name = name;
        }

       public void runTest() {
            try {
                long start = System.nanoTime();
                test();
                long duration = System.nanoTime() - start;

                System.out.format("%.2f\n", duration/1.0e9);
            } catch (Exception e) {
                e.printStackTrace();
            }


       }

       public abstract void test() throws Exception;
    }

    private static Tester[] testers  = {
            new Tester("stream write") {
                @Override
                public void test() throws Exception {
                    DataOutputStream out = new DataOutputStream(new FileOutputStream("temp.tmp"));
                    for (int i = 0; i < numOfInts; i++) {
                        out.writeInt(i); //如果这里写成write会报错.numOfInts/4
                    }
                    out.close();
                }
            },

            new Tester("mapped write") {
                @Override
                public void test() throws Exception {
                    FileChannel fc = new RandomAccessFile("temp.tmp", "rw")
                            .getChannel();
                    IntBuffer ib =
                            fc.map(FileChannel.MapMode.READ_WRITE, 0, fc.size()).asIntBuffer();
                    for (int i = 0; i < numOfInts; i++) {
                        ib.put(i);
                    }
                    fc.close();
                }
            },

            new Tester("stream read") {
                @Override
                public void test() throws Exception {
                    DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("temp.tmp")));
                    for (int i = 0; i < numOfInts; i++) {
                        in.readInt();
                    }
                    in.close();
                }
            },

            new Tester("mapped read") {
                @Override
                public void test() throws Exception {
                    FileChannel fc = new FileInputStream("temp.tmp").getChannel();
                    IntBuffer ib = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size()).asIntBuffer();
                    while (ib.hasRemaining()) {
                        ib.get();
                    }

                    fc.close();
                }
            },

            new Tester("stream read/write") {
                @Override
                public void test() throws Exception {
                    RandomAccessFile raf = new RandomAccessFile("temp.tmp", "rw");
                    raf.write(1);
                    for (int i = 0; i < numOfUbuffInts; i++) {
                        raf.seek(raf.length() - 4 );
                        raf.writeInt(raf.readInt());
                    }
                    raf.close();
                }
            },

            new Tester("mapped read/write") {
                @Override
                public void test() throws Exception {
                    FileChannel fc = new RandomAccessFile("temp.tmp", "rw").getChannel(); //这里如果用FileOutputStream报错
                    IntBuffer ib = fc.map(FileChannel.MapMode.READ_WRITE, 0, fc.size()).asIntBuffer();
                    ib.put(0);

                    for (int i = 1; i < numOfUbuffInts; i++) {
                        ib.put(ib.get(i - 1));
                    }
                    fc.close();
                }
            }
    };

    public static void main(String[] args) {
        testers[0].runTest();
        testers[1].runTest();
        testers[2].runTest();
        testers[3].runTest();
        testers[4].runTest();
        testers[5].runTest();
    }
}
