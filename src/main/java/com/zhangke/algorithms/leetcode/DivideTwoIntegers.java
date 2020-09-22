package com.zhangke.algorithms.leetcode;

/**
 * 29. 两数相除:
 * https://leetcode-cn.com/problems/divide-two-integers/
 * Created by ZhangKe on 2019/11/19.
 */
public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        if (dividend == 0) return 0;
        int sum = 0;
        int count = 0;
        long absDividend = Math.abs((long)dividend);
        long absDivisor = Math.abs(divisor);
        while (sum <= absDividend) {
            sum += absDivisor;
            count++;
        }
        if (count > 0) {
            count--;
        }
        if (dividend < 0 && divisor < 0) {
            return count;
        }
        if (dividend < 0 || divisor < 0) {
            return 0 - count;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new DivideTwoIntegers().divide(-2147483648, -1));
    }
}
