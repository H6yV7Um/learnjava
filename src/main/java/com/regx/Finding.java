package com.regx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * find()方法是有状态的，搜完了就没了。
 *
 * find(i) 这种find能根据参数的值不断重新设定搜索的起始位置
 *
 * Created by dongchunxu on 2017/8/2.
 */
public class Finding {
    public static void main(String[] args) {
        Matcher matcher = Pattern.compile("\\w+").matcher("Evening is full of linnet's wings");
        while (matcher.find()) {
            System.out.print(matcher.group() + " \t");
        }
        System.out.println();

        int i = 0;
        while (matcher.find(i)) {
            System.out.print(matcher.group() + " ");
            i++;
        }
    }
}
