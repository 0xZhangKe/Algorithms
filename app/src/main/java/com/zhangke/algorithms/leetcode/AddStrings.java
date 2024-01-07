package com.zhangke.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

public class AddStrings {

    public static void main(String[] args) {
        AddStrings addStrings = new AddStrings();
        System.out.println(addStrings.addStrings("11", "123"));
        System.out.println(addStrings.addStrings("456", "77"));
        System.out.println(addStrings.addStrings("0", "0"));
    }

    public String addStrings(String num1, String num2) {
        int maxLength = Math.max(num1.length(), num2.length());
        char[] num1CharArray = num1.toCharArray();
        char[] num2CharArray = num2.toCharArray();
        List<Integer> result = new ArrayList<>(maxLength + 1);
        int num1Space = maxLength - num1.length();
        int num2Space = maxLength - num2.length();
        boolean hasPlus = false;
        for (int i = maxLength - 1; i >= 0; i--) {
            int num1Item = getIntFromArray(num1CharArray, i, num1Space);
            int num2Item = getIntFromArray(num2CharArray, i, num2Space);
            int sum = num1Item + num2Item;
            if (hasPlus) {
                sum++;
            }
            hasPlus = sum > 9;
            result.add(0, sum % 10);
        }
        if (hasPlus) result.add(0, 1);
        StringBuilder builder = new StringBuilder();
        for (Integer integer : result) {
            builder.append(integer);
        }
        return builder.toString();
    }

    private int getIntFromArray(char[] array, int index, int space) {
        if (index - space < 0) return 0;
        return array[index - space] - 48;
    }
}
