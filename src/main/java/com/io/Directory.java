package com.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by dongchunxu on 2017/6/18.
 */
public class Directory {
    public interface SmsFilterRule {
        boolean match(String name);
    }

    public static File[] local(File dir, final String regex) {
        return dir.listFiles(new FilenameFilter() {
            final Pattern pattern = Pattern.compile(regex);
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        });
    }

    public static File[] local(String path, final String regex) {
        return local(new File(path), regex);
    }

    public static class TreeInfo implements Iterable<File> {
        List<File> files = new ArrayList<File>();
        List<File> dirs = new ArrayList<File>();

        public Iterator<File> iterator() {
            return files.iterator();
        }

        void addAll(TreeInfo info) {
            files.addAll(info.files);
            dirs.addAll(info.dirs);
        }
    }

    public static TreeInfo walk(File start, String regex) {
        return recurseDirs(start, regex);
    }

    public static TreeInfo walk(String start, String regex) {
        return recurseDirs(new File(start), ".*");
    }

    static TreeInfo recurseDirs(File startDir, String regex) {
        TreeInfo result = new TreeInfo();
        for (File item : startDir.listFiles()) {
            if (item.isDirectory()) {
                result.dirs.add(item);
                result.addAll(recurseDirs(item, regex));
            } else {
                if (item.getName().matches(regex)) {
                    result.files.add(item);
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
//        TreeInfo walk = walk(new File("."), ".*\\.xml");
//        System.out.println(walk.files);

        File file = new File(".test");
        System.out.println(file.getParent());
        System.out.println(file.getPath());

        File dest = new File("pom.xml");
        file.renameTo(dest);
    }
}
