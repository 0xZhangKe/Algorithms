package com.zhangke.algorithms;

import com.zhangke.algorithms.leetcode.Util;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        Util.printList(list.subList(3, list.size()));
    }

}
