package com.regx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Matcher 的 group, start, end
 * Created by dongchunxu on 2017/8/2.
 */
public class TestRegularExpression {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: \n java TestRegularExpression"
             + "characterSequence regularExpression");
            System.exit(0);
        }

        System.out.println("input: \"" + args[0] + "\"");

        for (String arg :  args) {
            System.out.println("Regular expression: \"" + arg + "\"");
            Pattern pattern = Pattern.compile(arg);
            Matcher m = pattern.matcher(args[0]);
            while (m.find()) {
                System.out.println("Match \"" + m.group() + "\" at positions " + m.start() + "-" + (m.end() - 1));
            }
        }

    }
}
