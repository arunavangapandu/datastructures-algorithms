package com.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class Easy {

    public String wordAppend(String[] strings) {
        Map<String, Integer> map = new HashMap<>();
        StringBuilder res = new StringBuilder("");
        for(String str: strings) {
            if(map.containsKey(str)) {
                map.put(str, map.get(str) + 1);
                int value = map.get(str);
                if(value % 2 == 0) {
                    res.append(str);
                }

            } else {
                map.put(str,1);
            }
        }
        return res.toString();
    }

}
