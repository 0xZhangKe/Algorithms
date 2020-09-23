package com.zhangke.algorithms.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 22. 括号生成:
 * https://leetcode-cn.com/problems/generate-parentheses/;
 * 使用回溯法解决这个问题.
 * Created by ZhangKe on 2019/9/12.
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    private void backtrack(List<String> list, String cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            list.add(cur);
            return;
        }
        if (open < max) {
            backtrack(list, cur + "(", open + 1, close, max);
        }
        if (close < open) {
            backtrack(list, cur + ")", open, close + 1, max);
        }
    }

    public static void main(String[] args) {
        Util.printListElementWithLine(new GenerateParentheses().generateParenthesis(5));
    }
}
