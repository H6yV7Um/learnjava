package com.nio;

import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.SortedMap;

/**
 * 查看支持的所有的编码和别名
 * Created by dongchunxu on 2017/6/20.
 */
public class AvailableCharSets {

    public static void main(String[] args) {
        SortedMap<String, Charset> charsets = Charset.availableCharsets();
        Iterator<String> iterator = charsets.keySet().iterator();
        while (iterator.hasNext()) {
            String csName = iterator.next();
            System.out.print(csName);

            Iterator<String> aliases = charsets.get(csName).aliases().iterator();

            if (aliases.hasNext()) {
                System.out.print(":");
            }
            while (aliases.hasNext()) {
                System.out.println(aliases.next());
                if (aliases.hasNext()) {
                    System.out.print(",");
                }
            }
        }
    }
}
