package com.leetcode.problems.medium;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

public class FilePrinter {

    public static void printNames(String startDir) {
        Queue<String> searchQueue = new LinkedList<>();
        searchQueue.add(startDir);

        while (!searchQueue.isEmpty()) {
            String dir = searchQueue.poll();
            File directory = new File(dir);
            String[] files = directory.list();

            if (files != null) {
                for (String file : files) {
                    String fullPath = directory.getPath() + "/" + file;
                    File fileObject = new File(fullPath);

                    if (fileObject.isFile()) {
                        System.out.println(file);
                    } else if (fileObject.isDirectory()) {
                        searchQueue.add(fullPath);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        printNames("pics");
    }
}