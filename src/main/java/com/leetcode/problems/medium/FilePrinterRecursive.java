package com.leetcode.problems.medium;

import java.io.File;
import java.util.Arrays;

public class FilePrinterRecursive {

    public static void printNames(String dir) {
        File directory = new File(dir);
        String[] files = directory.list();

        if (files != null) {
            Arrays.sort(files); // Sort the files alphabetically

            for (String file : files) {
                String fullPath = directory.getPath() + "/" + file;
                File fileObject = new File(fullPath);

                if (fileObject.isFile()) {
                    System.out.println(file);
                } else if (fileObject.isDirectory()) {
                    printNames(fullPath);
                }
            }
        }
    }

    public static void main(String[] args) {
        printNames("pics");
    }
}
