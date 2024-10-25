package com.leetcode.problems.medium;

import java.util.HashMap;
import java.util.Stack;

public class ParenthesesBalance {

    public static boolean isParenBalanced(String parenString) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> openingParen = new HashMap<>();
        openingParen.put(')', '(');
        openingParen.put(']', '[');
        openingParen.put('}', '{');

        for (char paren : parenString.toCharArray()) {
            if (openingParen.containsValue(paren)) {
                // We met an opening parenthesis, just putting it on the stack
                stack.push(paren);
            } else if (openingParen.containsKey(paren)) {
                // We met a closing parenthesis
                if (stack.isEmpty() || stack.pop() != openingParen.get(paren)) {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isParenBalanced("(())")); // Outputs: true
        System.out.println(isParenBalanced("({[)}")); // Outputs: false
    }
}