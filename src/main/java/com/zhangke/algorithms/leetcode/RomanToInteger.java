package com.zhangke.algorithms.leetcode;

import java.util.HashMap;

/**
 * 罗马数字转整数：https://leetcode-cn.com/problems/roman-to-integer/
 */
public class RomanToInteger {

    public int romanToInt(String s) {
        HashMap<String, Integer> romanMap = new HashMap<>();
        romanMap.put("M", 1000);
        romanMap.put("CM", 900);
        romanMap.put("D", 500);
        romanMap.put("CD", 400);
        romanMap.put("C", 100);
        romanMap.put("XC", 90);
        romanMap.put("L", 50);
        romanMap.put("XL", 40);
        romanMap.put("X", 10);
        romanMap.put("IX", 9);
        romanMap.put("V", 5);
        romanMap.put("IV", 4);
        romanMap.put("I", 1);

        int n = 0;
        String tmp;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (i < length - 1) {
                tmp = s.substring(i, i + 2);
                if (romanMap.containsKey(tmp)) {
                    i++;
                    n += romanMap.get(tmp);
                    continue;
                }
            }
            n += romanMap.get(String.valueOf(s.charAt(i)));
        }
        return n;
    }

    public static void main(String[] args) {
        RomanToInteger romanToInteger = new RomanToInteger();
        System.out.println(romanToInteger.romanToInt("XXVII"));
    }
}
