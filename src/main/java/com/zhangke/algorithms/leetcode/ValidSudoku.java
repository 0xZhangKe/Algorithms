package com.zhangke.algorithms.leetcode;

import java.util.HashMap;

/**
 * 36. 有效的数独:
 * https://leetcode-cn.com/problems/valid-sudoku/
 * Created by ZhangKe on 2020/3/25.
 */
public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, Integer>[] rows = new HashMap[9];
        HashMap<Integer, Integer>[] columns = new HashMap[9];
        HashMap<Integer, Integer>[] boxes = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<>();
            columns[i] = new HashMap<>();
            boxes[i] = new HashMap<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int itemRow = board[j][i];
                if (itemRow != (int) '.') {
                    if (rows[i].containsKey(itemRow)) {
                        return false;
                    } else {
                        rows[i].put(itemRow, j);
                    }
                }
                int itemColumn = board[i][j];
                if (itemColumn != (int) '.') {
                    if (columns[i].containsKey(itemColumn)) {
                        return false;
                    } else {
                        columns[i].put(itemColumn, i);
                    }
                }
                int boxesIndex = (i / 3) * 3 + j / 3;
                int itemBoxes = board[i][j];
                if (itemBoxes != (int) '.') {
                    if (boxes[boxesIndex].containsKey(itemBoxes)) {
                        return false;
                    } else {
                        boxes[boxesIndex].put(itemBoxes, j);
                    }
                }
            }
        }
        return true;
    }

//    public boolean isValidSudoku(char[][] board) {
//        List<Character> lineList = new ArrayList<>(9);
//        List<Character> columnList = new ArrayList<>(9);
//        List<Character> rec = new ArrayList<>(9);
//        for (int i = 0; i < 9; i++) {
//            lineList.clear();
//            columnList.clear();
//            for (int j = 0; j < 9; j++) {
//                char lineValue = board[i][j];
//                if (validValue(lineValue) ||
//                        (lineValue != '.' && lineList.contains(lineValue))) {
//                    return false;
//                }
//                lineList.add(lineValue);
//                char columnValue = board[j][i];
//                if (validValue(columnValue) ||
//                        (columnValue != '.' && columnList.contains(columnValue))) {
//                    return false;
//                }
//                columnList.add(columnValue);
//            }
//            if(i % 3 == 0){
//                for(int j = 0; j < 9; j++){
//                    int columnIndex = j % 3;
//                    if(columnIndex == 0){
//                        rec.clear();
//                    }
//                    for(int iii = 0; iii < 3; iii++){
//                        char value = board[i + iii][j];
//                        if(validValue(value) ||
//                                (value != '.' && rec.contains(value))){
//                            return false;
//                        }
//                        rec.add(value);
//                    }
//                }
//            }
//        }
//        return true;
//    }
//
//    private boolean validValue(char c) {
//        return !(c >= (int) '0' && c <= (int) '9') && c != '.';
//    }

    public static void main(String[] args) {
        ValidSudoku sodu = new ValidSudoku();
//        String[][] original = {
//                {"5", "3", ".", ".", "7", ".", ".", ".", "."},
//                {"6", ".", ".", "1", "9", "5", ".", ".", "."},
//                {".", "9", "8", ".", ".", ".", ".", "6", "."},
//                {"8", ".", ".", ".", "6", ".", ".", ".", "3"},
//                {"4", ".", ".", "8", ".", "3", ".", ".", "1"},
//                {"7", ".", ".", ".", "2", ".", ".", ".", "6"},
//                {".", "6", ".", ".", ".", ".", "2", "8", "."},
//                {".", ".", ".", "4", "1", "9", ".", ".", "5"},
//                {".", ".", ".", ".", "8", ".", ".", "7", "9"}
//        };
        //[[],[],[],[],[],[],[],[],[]]
        String[][] original = {
                {"7", ".", ".", ".", "4", ".", ".", ".", "."},
                {".", ".", ".", "8", "6", "5", ".", ".", "."},
                {".", "1", ".", "2", ".", ".", ".", ".", "."},
                {".", ".", ".", ".", ".", "9", ".", ".", "."},
                {".", ".", ".", ".", "5", ".", "5", ".", "."},
                {".", ".", ".", ".", ".", ".", ".", ".", "."},
                {".", ".", ".", ".", ".", ".", "2", ".", "."},
                {".", ".", ".", ".", ".", ".", ".", ".", "."},
                {".", ".", ".", ".", ".", ".", ".", ".", "."}
        };
        char[][] board = new char[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = original[i][j].toCharArray()[0];
            }
        }
        System.out.println(sodu.isValidSudoku(board));
    }
}
