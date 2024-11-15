package com.leetcode.problems.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParenthesis {

    public boolean isValidString(String input) {
        if(input == null || input.isBlank() || input.isEmpty()) {
            return false;
        }
        // Time and Space complexity is O(n)
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']','[');

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            } else {
                if(map.containsKey(c) && !stack.empty()) {
                    if(map.get(c) == stack.peek()) {
                        stack.pop();
                    }
                } else {
                    return false;
                }
            }

        }
        return stack.empty();
    }

    public static void main(String[] args) {
        System.out.println(new ValidParenthesis().isValidString("[]{}"));
        System.out.println(new ValidParenthesis().isValidString("[{}") );

    }
}
