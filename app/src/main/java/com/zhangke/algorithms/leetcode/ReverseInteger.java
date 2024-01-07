package com.zhangke.algorithms.leetcode;

import java.util.Stack;

/**
 * 整数反转：https://leetcode-cn.com/problems/reverse-integer/
 * <p>
 * Created by ZhangKe on 2019/6/11.
 */
public class ReverseInteger {

    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        System.out.println(reverseInteger.reverse(123));
    }

    public int reverse(int x) {
        Stack<Integer> stack = new Stack<>();
        long plusNumber = Math.abs(x);
        long surplus = 10L;
        long total = 0L;
        long tmp;
        while (surplus <= plusNumber * 10L) {
            tmp = (plusNumber % surplus - total);
            total += tmp;
            stack.push((int) (tmp / (surplus / 10L)));
            surplus = surplus * 10L;
        }
        long result = 0;
        int i = 0;
        while (!stack.isEmpty()) {
            result += stack.pop() * Math.pow(10, i++);
        }
        if (x < 0) {
            result = 0 - result;
        }
        if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
            return 0;
        }
        return (int) result;
    }
}
