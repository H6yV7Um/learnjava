package com.io.input;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * Created by dongchunxu on 2017/6/18.
 */
public class BinaryFile {
    public static byte[] read(File bFile) throws Exception{
        BufferedInputStream bf = new BufferedInputStream(new FileInputStream(bFile));
        try {
            byte[] data = new byte[bf.available()];
            bf.read(data);
            return data;
        } finally {
            bf.close();
        }
    }
}
