package com.zhangke.algorithms.leetcode;

import java.util.Stack;

/**
 * 回文数：https://leetcode-cn.com/problems/palindrome-number/
 * <p>
 * Created by ZhangKe on 2019/6/13.
 */
public class PalindromeNumber {

    public static void main(String[] args) {
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        System.out.println(palindromeNumber.isPalindrome(-122));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        long result = reverse(x);
        return result == x;
    }

    public long reverse(int x) {
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
        return result;
    }
}
