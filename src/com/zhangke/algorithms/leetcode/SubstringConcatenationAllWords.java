package com.zhangke.algorithms.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 30. 串联所有单词的子串:
 * https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words/
 * Created by ZhangKe on 2019/11/20.
 */
public class SubstringConcatenationAllWords {

    public List<Integer> findSubstring(String s, String[] words) {
        if (s.isEmpty()) return Collections.emptyList();
        if (words.length <= 0) return Collections.emptyList();
        int position = 0;
        int sLen = s.length();
        int step = words.length * words[0].length();
        String tmp;
        while (position + step < sLen) {
            tmp = s.substring(position, position + step);

            position++;
        }
    }

    private List<String> getAllStrings(String[] words){
        List<String> list = new ArrayList<>();

        return list;
    }

    private void buildStrings(String[] words, Stack<String> stack, int position, List<String> list){
        if(stack.size() == words.length){
//            list.add()
        }else{


            if(position < words.length){
                stack.push(words[position]);
                buildStrings(words, stack, position+1, list);
            }else{

            }
        }
    }

    public static void main(String[] args) {
        SubstringConcatenationAllWords sub = new SubstringConcatenationAllWords();
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        Util.printListElementWithLine(sub.findSubstring(s, words));
    }
}
