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
        String prefix = "";
        int length = strs[0].length();
        String tmpPrefix = "";
        boolean breaked = false;
        for (int i = 1; i <= length; i++) {
            prefix = tmpPrefix;
            tmpPrefix = strs[0].substring(0, i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() < i) {
                    breaked = true;
                    break;
                }
                if (!tmpPrefix.equals(strs[j].substring(0, i))) {
                    breaked = true;
                    break;
                }
            }
        }
        if (breaked) {
            prefix = tmpPrefix;
        }
        return prefix;
    }

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        System.out.println(longestCommonPrefix.longestCommonPrefix(new String[]{"c", "c"}));
    }
}
