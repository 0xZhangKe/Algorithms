package com.zhangke.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成:
 * https://leetcode-cn.com/problems/generate-parentheses/
 * Created by ZhangKe on 2019/9/12.
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<Character> charList = new ArrayList<>();
        for(int i = 0; i < n * 2; i++){
            charList.add(i % 2 == 0 ? '(' : ')');
        }
        List<String> result = new ArrayList<>();
        for()
    }

    public static void main(String[] args) {
        Util.printListElementWithLine(new GenerateParentheses().generateParenthesis(3));
    }
}
