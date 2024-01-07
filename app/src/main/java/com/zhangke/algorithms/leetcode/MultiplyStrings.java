package com.zhangke.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MultiplyStrings {

    public static void main(String[] args) {
        MultiplyStrings multiplyStrings = new MultiplyStrings();
        System.out.println(multiplyStrings.multiply("91444", "0"));
    }

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        String sum = "0";
        char[] num1Array = num1.toCharArray();
        char[] num2Array = num2.toCharArray();
        for (int i = num2Array.length - 1; i >= 0; i--) {
            int factory = num2Array[i] - 48;
            StringBuilder sumBuilder = new StringBuilder();
            int zeroCount = num2Array.length - 1 - i;
            for (int c = 0; c < zeroCount; c++) {
                sumBuilder.append('0');
            }
            int plusNumber = 0;
            for (int j = num1Array.length - 1; j >= 0; j--) {
                int num1Factory = num1Array[j] - 48;
                int thisTimeSum = plusNumber + factory * num1Factory;
                sumBuilder.insert(0, thisTimeSum % 10);
                plusNumber = thisTimeSum / 10;
            }
            if (plusNumber > 0) {
                sumBuilder.insert(0, plusNumber);
            }
            sum = addStrings(sum, sumBuilder.toString());
        }
        return sum;
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

