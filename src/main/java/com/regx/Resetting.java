package com.regx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 使用不带参数的reset ,可以将Matcher对象重新设置到当前字符序列的起始位置
 * 使用带参数的reset, 可以用一个新的字符串来重置Matcher
 * Created by dongchunxu on 2017/8/3.
 */
public class Resetting {
    public static void main(String[] args) {
        Matcher m = Pattern.compile("[frb][aiu][gx]").matcher("fix the rug with bags");

        while (m.find()) {
            System.out.print(m.group() + " ");
        }
        System.out.println();

        m.reset("fix the rig with rags");
        while (m.find()) {
            System.out.print(m.group() + " ");
        }
    }
}
