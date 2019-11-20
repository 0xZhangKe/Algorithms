package com.zhangke.algorithms.leetcode;

import java.util.Collections;
import java.util.List;

/**
 * 30. 串联所有单词的子串:
 * https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words/
 * Created by ZhangKe on 2019/11/20.
 */
public class SubstringConcatenationAllWords {

    public List<Integer> findSubstring(String s, String[] words) {
        if(s.isEmpty()) return Collections.emptyList();
        if(words.length <= 0) return Collections.emptyList();
        int position = 0;
        int sLen = s.length();
        int step = words[0].length();
        String tmp;
        while(position < sLen){
            tmp = s.substring(position, step);

            position = position + step;
        }
    }

    public static void main(String[] args) {
        SubstringConcatenationAllWords sub = new SubstringConcatenationAllWords();
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        Util.printListElementWithLine(sub.findSubstring(s, words));
    }
}
