package com.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class Maps {

    public Map<String, Integer> word0(String[] strings) {
        Map<String, Integer> map = new HashMap();
//        for (String s:strings) {
//            map.put(s, 0);
//        }

//        for(String str: strings) {
//            map.put(str, str.length());
//        }


        return map;
    }

    public static void main(String[] args) {
        Map map = new Maps().word0(new String[] {"a", "b", "a", "b"});
        System.out.println(map);
    }
}
