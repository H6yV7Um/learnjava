package com.regx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * lookingAt只有在正则表达式与输入的最开始处就开始匹配时才会成功
 * Created by dongchunxu on 2017/8/2.
 */
public class StartEnd {
    public static String input =
            "As long as there is injustice. whenever a\n" +
                    "Targathian baby cries out, whenever a distress\n" +
                    "signal sounds among the stars... we'll be there.\n" +
                    "This fine ship, and this find crew...\n" +
                    "Never give up! Never surrender!";

    private static class Display {
        private boolean regexPrinted = false;
        private String regex;

        public Display(String regex) {
            this.regex = regex;
        }

        void display(String message) {
            if (!regexPrinted) {
                System.out.println(regex);
                regexPrinted = true;
            }

            System.out.println(message);
        }
    }

    static void examine(String s, String regex) {
        Display display = new Display(regex);
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(s);

        while (m.find()) {
            display.display("find() '" + m.group() + "' start = " + m.start() + " end = " + m.end());
        }

        if (m.lookingAt()) {    // no reset necessary
            display.display("lookingAt() start = " + m.start() + " end = " + m.end());
        }
        if (m.matches()) {    // no reset necessary
            display.display("matches() start = " + m.start() + " end = " + m.end());
        }
    }

    public static void main(String[] args) {
        for (String in : input.split("\n")) {
            System.out.println("input: " + in);

            for (String regex : new String[]{"\\w*ere\\w*", "\\w*ever", "T\\w+", "Never.*?!"}) {
                examine(in, regex);
            }
        }
    }
}
