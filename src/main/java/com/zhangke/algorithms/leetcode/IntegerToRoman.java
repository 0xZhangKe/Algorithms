package com.zhangke.algorithms.leetcode;

/**
 * 整数转罗马数字:https://leetcode-cn.com/problems/integer-to-roman/
 */
public class IntegerToRoman {

    private final static char ROMAN_1 = 'I';
    private final static char ROMAN_5 = 'V';
    private final static char ROMAN_10 = 'X';
    private final static char ROMAN_50 = 'L';
    private final static char ROMAN_100 = 'C';
    private final static char ROMAN_500 = 'D';
    private final static char ROMAN_1000 = 'M';

    public static void main(String[] args) {
        IntegerToRoman roman = new IntegerToRoman();
        System.out.println(roman.intToRoman(4));
        System.out.println(roman.intToRoman(5));
        System.out.println(roman.intToRoman(900));
        System.out.println(roman.intToRoman(12));
        System.out.println(roman.intToRoman(27));
        System.out.println(roman.intToRoman(1994));
    }

    public String intToRoman(int num) {
        return doIntToRoman(num, new StringBuilder());
    }

    private String doIntToRoman(int num, StringBuilder result) {
        if (num == 0) {
            return result.toString();
        }
        int value;
        if (num >= 1000) {
            result.append(ROMAN_1000);
            value = num - 1000;
        } else if (num >= 900) {
            result.append(ROMAN_100);
            result.append(ROMAN_1000);
            value = num - 900;
        } else if (num >= 500) {
            result.append(ROMAN_500);
            value = num - 500;
        } else if (num >= 400) {
            result.append(ROMAN_100);
            result.append(ROMAN_500);
            value = num - 400;
        } else if (num >= 100) {
            result.append(ROMAN_100);
            value = num - 100;
        } else if (num >= 90) {
            result.append(ROMAN_10);
            result.append(ROMAN_100);
            value = num - 90;
        } else if (num >= 50) {
            result.append(ROMAN_50);
            value = num - 50;
        } else if (num >= 40) {
            result.append(ROMAN_10);
            result.append(ROMAN_50);
            value = num - 40;
        } else if (num >= 10) {
            result.append(ROMAN_10);
            value = num - 10;
        } else if (num >= 9) {
            result.append(ROMAN_1);
            result.append(ROMAN_10);
            value = num - 9;
        } else if (num >= 5) {
            result.append(ROMAN_5);
            value = num - 5;
        } else if (num >= 4) {
            result.append(ROMAN_1);
            result.append(ROMAN_5);
            value = num - 4;
        } else {
            result.append(ROMAN_1);
            value = num - 1;
        }
        return doIntToRoman(value, result);
    }
}
