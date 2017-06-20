package com.io.restore;

import java.io.*;

/**
 * Created by dongchunxu on 2017/6/18.
 */
public class StoringAndRecoveringData {

    public static void main(String[] args) throws Exception {
        DataOutputStream out  = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("data.out")));
        out.writeDouble(Math.PI);
        out.writeUTF("我是董春旭");
        out.writeDouble(1.11);
        out.writeUTF("这是写的文字");
        out.close();

        DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("data.out")));
        System.out.println(in.readDouble());
        System.out.println(in.readUTF());
        System.out.println(in.readDouble());
        System.out.println(in.readUTF());
    }

}
