package com.regx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * find 寻找一次符合匹配条件的序列
 *
 * Created by dongchunxu on 2017/8/2.
 */
public class Groups {

    private static final String POEM = "Twas brillig, and the slithy toves\n" +
            "Dis gyre and gimble in the wabe.\n" +
            "All mimsy were the borogoves,\n " +
            "And the mome raths outgrabe. \n\n" +
            "Beware the Jabberwock, my son, \n" +
            "The jaws that bite, the claws that catch.\n" +
            "Beware the jubjub bird, and shun \n" +
            "The frumious Bandersnatch.";

    public static void main(String[] args) {
        /**
         * (?m) 显示的告知正则表达式注意序列中的换行符
         *
         * */
        Matcher m =
                Pattern.compile("(?m)(\\S+)\\s+((\\S+)\\s+(\\S+))$")
                .matcher(POEM);
        while (m.find()) {
            for (int j = 0; j < m.groupCount(); j++) {
                System.out.print("[" + m.group(j) + "]");
            }
            System.out.println();
        }

    }

}
