package com.zhangke.algorithms.leetcode;

public class RegularExpressionMatching {

    public static void main(String[] args) {
        RegularExpressionMatching matching = new RegularExpressionMatching();
//        System.out.println(matching.isMatch("aa", "a"));
//        System.out.println(matching.isMatch("aa", "a*"));
//        System.out.println(matching.isMatch("ab", ".*"));
        System.out.println(matching.isMatch("aab", "c*a*b*"));
    }

    public boolean isMatch(String s, String p) {
        char[] rules = p.toCharArray();
        char[] targetArray = s.toCharArray();
        int index = 0;
        int validIndex = -1;
        char currentChar;
        char nextChar;
        boolean nextIsSnow;
        while (index < rules.length) {
            if (validIndex == targetArray.length - 1) break;
            currentChar = rules[index];
            if (index < rules.length - 1) {
                nextChar = rules[index + 1];
                nextIsSnow = nextChar == '*';
            } else {
                nextIsSnow = false;
            }
            if (nextIsSnow) {
                int i = validIndex + 1;
                while (i < targetArray.length) {
                    if (targetArray[i] == currentChar || currentChar == '.') {
                        i++;
                    } else {
                        break;
                    }
                }
                validIndex = i - 1;
            } else {
                if (targetArray[validIndex + 1] == currentChar || currentChar == '.') {
                    validIndex++;
                }
            }
            index++;
        }
        return validIndex == targetArray.length - 1;
    }
}
