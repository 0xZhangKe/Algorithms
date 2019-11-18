package com.zhangke.algorithms.leetcode;

/**
 * 28. 实现 strStr():
 * https://leetcode-cn.com/problems/implement-strstr/
 * Created by ZhangKe on 2019/11/18.
 */
public class ImplementStrstr {

    public int strStr(String haystack, String needle) {
        if (haystack.equals(needle)) return 0;
        if (haystack.isEmpty()) return -1;
        if (needle.isEmpty()) return 0;
        char[] haystackArray = haystack.toCharArray();
        char[] needleArray = needle.toCharArray();
        int needleLen = needleArray.length;
        int position = 0;
        int j;
        while (position < haystackArray.length - needleLen + 1) {
            j = 0;
            while (j < needleLen) {
                if (haystackArray[position + j] != needleArray[j++]) {
                    j--;
                    break;
                }
            }
            if (j == needleLen) {
                return position;
            }
            position++;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new ImplementStrstr().strStr("sipi", "pi"));
    }
}
