package com.zhangke.algorithms.leetcode;

import com.zhangke.algorithms.Util;

/**
 * Z 字形变换：https://leetcode-cn.com/problems/zigzag-conversion/
 * Created by ZhangKe on 2019/6/11.
 */
public class ZigZag {

    private final char DEFAULT_VALUE = Character.MAX_VALUE;

    public static void main(String[] args) {
        ZigZag zigZag = new ZigZag();
        System.out.println(zigZag.convert("PAYPALISHIRING", 3));
    }

    public String convert(String s, int numRows) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        if (numRows < 2) {
            return s;
        }
        int length = s.length();
        char[] charData = s.toCharArray();
        int line = getLine(numRows, length);
        char[][] recordTable = new char[line][numRows];
        int position = 0;//用于按照顺序从字符串中读取数据
        int curLine = 1;//当前行，从 1 开始，达到 numRows 后重新计数
        int totalLine = 0;//当前正在使用的行数，新增一行加一
        int rowPosition;
        int rowIndex = 0;
        while (position < length) {
            if (curLine == numRows) {
                curLine = 1;
            }
            if (curLine == 1) {
                rowPosition = 0;
                rowIndex = numRows - 1;
                while (rowPosition < numRows && position < length) {
                    recordTable[totalLine][rowPosition] = charData[position++];
                    rowPosition++;
                }
            } else {
                rowPosition = 0;
                while (rowPosition < numRows && position < length) {
                    if (rowPosition == rowIndex) {
                        recordTable[totalLine][rowPosition] = charData[position++];
                    } else {
                        recordTable[totalLine][rowPosition] = DEFAULT_VALUE;
                    }
                    rowPosition++;
                }
            }
            curLine++;
            totalLine++;
            rowIndex--;
        }
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < numRows; i++){
            for(int j = 0; j < recordTable.length; j++){
                char c = recordTable[j][i];
                if (c != DEFAULT_VALUE && c != 0) {
                    builder.append(c);
                }
            }
        }
        return builder.toString();
    }

    private int getLine(int numRows, int length) {
        int curLine = 1;
        int position = 0;
        int totalLine = 0;
        while (position < length) {
            if (curLine == numRows) {
                curLine = 1;
            }
            if (curLine == 1) {
                position += numRows;
            } else {
                position++;
            }
            curLine++;
            totalLine++;
        }
        return totalLine;
    }
}
