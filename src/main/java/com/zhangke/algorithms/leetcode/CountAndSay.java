package com.zhangke.algorithms.leetcode;

/**
 * 38. 外观数列:
 * https://leetcode-cn.com/problems/count-and-say/
 * Created by ZhangKe on 2020/4/16.
 */
public class CountAndSay {

    public String countAndSay(int n) {
        String curLineDes = "1";
        int start = 2;
        while (start <= n) {
            curLineDes = getDescription(curLineDes);
            start++;
        }
        return curLineDes;
    }

    private String getDescription(String line) {
        if (line == null || line.isEmpty()) return "";
        StringBuilder builder = new StringBuilder();
        char[] sequence = line.toCharArray();
        char lastChar = 0;
        int lastCharCount = 0;
        int position = 0;
        while (position < sequence.length) {
            if (lastChar == sequence[position]) {
                lastCharCount++;
            } else {
                if (lastChar != 0) {
                    builder.append(lastCharCount);
                    builder.append(lastChar);
                }
                lastChar = sequence[position];
                lastCharCount = 1;
            }
            position++;
        }
        if (lastChar != 0) {
            builder.append(lastCharCount);
            builder.append(lastChar);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        CountAndSay cas = new CountAndSay();
        System.out.println(cas.countAndSay(1));
        System.out.println(cas.countAndSay(2));
        System.out.println(cas.countAndSay(3));
        System.out.println(cas.countAndSay(4));
        System.out.println(cas.countAndSay(30));
    }
}
