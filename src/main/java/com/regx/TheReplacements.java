package com.regx;

import com.utils.TextFile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by dongchunxu on 2017/8/2.
 */
public class TheReplacements {
    public static void main(String[] args) {
        String s = TextFile.readFile("src/main/java/com/regx/TheReplacements.java");
        Matcher mInput = Pattern.compile("/\\*!(.*)!\\*/", Pattern.DOTALL).matcher(s);

        if (mInput.find()) {
            s = mInput.group(1);  // Captured by parentheses
        }

        s = s.replaceAll(" {2,}", " "); //将两个或两个以上的空白符替换成单个
        s = s.replaceAll("(?m)^ +", "");    //去掉开头的空白符 -----注意多行模式

        System.out.println(s);

        s = s.replaceFirst("[aeiou]", "(VOWEL1)");
        System.out.println(s);

        StringBuffer sbuf = new StringBuffer();
        Pattern p = Pattern.compile("[aeiou]");
        Matcher matcher = p.matcher(s);

        while (matcher.find()) {
            matcher.appendReplacement(sbuf, matcher.group().toUpperCase());
        }

        matcher.appendTail(sbuf);

        System.out.println(sbuf);

    }
}
