package com.zhangke.algorithms.leetcode;

import java.util.Stack;

/**
 * 20. 有效的括号:
 * https://leetcode-cn.com/problems/valid-parentheses/
 * Created by ZhangKe on 2019/9/10.
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        if (s == null || s.isEmpty()) return true;
        if (s.length() % 2 != 0) return false;
        char[] array = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < array.length; i++) {
            if (stack.isEmpty() || isLeftP(array[i])) {
                stack.push(array[i]);
            } else {
                if (!charEquals(stack.pop(), array[i])) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean isLeftP(char c){
        return c == '[' || c == '{' || c == '(';
    }

    private boolean charEquals(char c1, char c2) {
        return (c1 == '[' && c2 == ']') || (c1 == '(' && c2 == ')') || (c1 == '{' && c2 == '}');
    }

    public static void main(String[] args) {
        System.out.println(new ValidParentheses().isValid("{[[]}"));
    }
}
