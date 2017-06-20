package com.io.process;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by dongchunxu on 2017/6/18.
 */
public class OSExceute {
    public static void command(String command) {
        boolean err = false;
        try {
            Process process = new ProcessBuilder(command.split(" ")).start();
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String s;
            while ((s = in.readLine()) != null) {
                System.out.println(s);
            }

            BufferedReader errors = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            while ((s = errors.readLine()) != null) {
                System.out.println(s);
                err = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        command("ps -ef");
    }
}
