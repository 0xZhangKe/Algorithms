package com.zhangke.algorithms.leetcode;

/**
 * 最长公共前缀:https://leetcode-cn.com/problems/longest-common-prefix/
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        boolean end = false;
        int position = 0;
        char thisLineChar;
        char tmp;
        int i;
        while (!end) {
            i = 0;
            thisLineChar = 0;
            while (i < strs.length) {
                if (position >= strs[i].length()) {
                    position--;
                    end = true;
                    break;
                }
                tmp = strs[i].charAt(position);
                if (thisLineChar == 0 || thisLineChar == tmp) {
                    thisLineChar = tmp;
                } else {
                    position--;
                    end = true;
                    break;
                }
                i++;
            }
            position++;
        }
        return strs[0].substring(0, position);
    }

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        System.out.println(longestCommonPrefix.longestCommonPrefix(new String[]{"c", "c"}));
    }
}
