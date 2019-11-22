package com.zhangke.algorithms.leetcode;

import java.util.*;

/**
 * 30. 串联所有单词的子串:
 * https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words/
 * Created by ZhangKe on 2019/11/20.
 */
public class SubstringConcatenationAllWords {

    public List<Integer> findSubstring(String s, String[] words) {
        if (s.isEmpty()) return Collections.emptyList();
        if (words.length <= 0) return Collections.emptyList();
        List<String> list = new ArrayList<>();
        getAllStrings(words, new ArrayList<>(), new ArrayList<>(), list);
        List<Integer> result = new ArrayList<>();
        int position = 0;
        int sLen = s.length();
        int step = words.length * words[0].length();
        String tmp;
        while (position + step <= sLen) {
            tmp = s.substring(position, position + step);
            if(list.contains(tmp)){
                result.add(position);
            }
            position++;
        }
        return result;
    }

    private void getAllStrings(String[] words, List<String> stringList, List<Integer> positionList, List<String> list) {
        if (stringList.size() == words.length) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < stringList.size(); i++) {
                builder.append(stringList.get(i));
            }
            list.add(builder.toString());
        } else {
            for (int i = 0; i < words.length; i++) {
                if (!positionList.contains(i)) {
                    positionList.add(i);
                    stringList.add(words[i]);
                    getAllStrings(words, stringList, positionList, list);
                    positionList.remove(Integer.valueOf(i));
                    if (!stringList.isEmpty()) {
                        stringList.remove(stringList.size() - 1);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        SubstringConcatenationAllWords sub = new SubstringConcatenationAllWords();
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word","good","best","good"};
        Util.printListElementWithLine(sub.findSubstring(s, words));
    }
}
