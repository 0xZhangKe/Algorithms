package com.zhangke.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 字符串转整数:https://leetcode-cn.com/problems/string-to-integer-atoi/
 * <p>
 * Created by ZhangKe on 2019/6/12.
 */
public class StringToIntegerAtoi {

    public static void main(String[] args) {
        StringToIntegerAtoi atoi = new StringToIntegerAtoi();
        System.out.println(atoi.myAtoi("  91283472332"));
    }

    public int myAtoi(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        char[] charArray = str.toCharArray();
        int position = 0;
        int length = charArray.length;
        Stack<Character> stack = new Stack<>();
        boolean isNegative = false;//是否为负数
        boolean firstEffectChar = true;
        while (position < length) {
            char c = charArray[position++];
            if (c == ' ') {
                if (!firstEffectChar) {
                    break;
                }
                continue;
            }
            if (c >= '0' && c <= '9') {
                stack.push(c);
            } else if (c == '-' && firstEffectChar) {
                isNegative = true;
            } else if (c == '+' && firstEffectChar) {
                isNegative = false;
            } else {
                break;
            }
            firstEffectChar = false;
        }
        if (stack.isEmpty()) {
            return 0;
        }
        long longNumber = 0;
        int i = 0;
        while (!stack.isEmpty()) {
            char c = stack.pop();
            longNumber += (c - 48) * Math.pow(10, i++);
        }
        if (isNegative) {
            longNumber = 0 - longNumber;
            return longNumber < Integer.MIN_VALUE ? Integer.MIN_VALUE : (int) longNumber;
        } else {
            return longNumber > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) longNumber;
        }
    }
}
