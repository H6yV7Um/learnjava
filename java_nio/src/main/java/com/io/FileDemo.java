package com.io;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Created by dongchunxu on 2017/6/18.
 */
public class FileDemo {

    public static void main(String[] args) {
        File file = new File(".");
//  1 列出所有文件和目录
// String[] list = file.list();
//

    //2 列出指定的文件
        String[] files = file.list(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith("xml");
            }
        });
        print(files);

    }

    private static void print(String[] list) {
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }
    }
}
