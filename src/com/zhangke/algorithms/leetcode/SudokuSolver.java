package com.zhangke.algorithms.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 37. 解数独:
 * https://leetcode-cn.com/problems/sudoku-solver/
 * Created by ZhangKe on 2020/3/26.
 */
public class SudokuSolver {

    int count = 0;

    public void solveSudoku(char[][] board) {
        List<Character>[] rowRecord = new ArrayList[9];
        List<Character>[] columnRecord = new ArrayList[9];
        List<Character>[] boxRecord = new ArrayList[9];
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                Character c = board[row][column];
                if (rowRecord[row] == null) {
                    rowRecord[row] = new ArrayList<>(9);
                }
                if (columnRecord[column] == null) {
                    columnRecord[column] = new ArrayList<>(9);
                }
                int boxIndex = (row / 3) * 3 + column / 3;
                if (boxRecord[boxIndex] == null) {
                    boxRecord[boxIndex] = new ArrayList<>(9);
                }
                if (c != '.') {
                    rowRecord[row].add(c);
                    columnRecord[column].add(c);
                    boxRecord[boxIndex].add(c);
                }
            }
        }
        backtrack(board, 0, 0, rowRecord, columnRecord, boxRecord);
    }

    private boolean backtrack(char[][] board,
                              int row, int column,
                              List<Character>[] rowRecord,
                              List<Character>[] columnRecord,
                              List<Character>[] boxRecord) {
        count++;
//        System.out.println("row:" + row + ",column:" + column);
        if (row == 9) {
            return true;
        }
        int nextRow = column < 8 ? row : row + 1;
        int nextColumn = column < 8 ? column + 1 : 0;
        int boxIndex = (row / 3) * 3 + column / 3;
        Character currentChar = board[row][column];
        if (currentChar == '.') {
            for (int i = 1; i < 10; i++) {
                Character c = (char) (i + 48);
                if (!rowRecord[row].contains(c) &&
                        !columnRecord[column].contains(c) &&
                        !boxRecord[boxIndex].contains(c)) {
                    board[row][column] = c;
                    rowRecord[row].add(c);
                    columnRecord[column].add(c);
                    boxRecord[boxIndex].add(c);
                    if (!backtrack(board, nextRow, nextColumn, rowRecord, columnRecord, boxRecord)) {
                        board[row][column] = currentChar;
                        rowRecord[row].remove(c);
                        columnRecord[column].remove(c);
                        boxRecord[boxIndex].remove(c);
                    } else {
                        return true;
                    }
                }
            }
        } else {
            return backtrack(board, nextRow, nextColumn, rowRecord, columnRecord, boxRecord);
        }
        return false;
    }

    public static void printBoard(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            StringBuilder rowBuilder = new StringBuilder();
            rowBuilder.append("[");
            char[] rowItem = board[row];
            for (int column = 0; column < rowItem.length; column++) {
                rowBuilder.append(rowItem[column]);
                if (column != rowItem.length - 1) {
                    rowBuilder.append(",    ");
                }
            }
            rowBuilder.append("]");
            if (row != board.length - 1) {
                rowBuilder.append("\n");
            }
            System.out.println(rowBuilder.toString());
        }
    }

    public static void main(String[] args) {
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
        String[][] original = {
                {".", ".", "9", "7", "4", "8", ".", ".", "."},
                {"7", ".", ".", ".", ".", ".", ".", ".", "."},
                {".", "2", ".", "1", ".", "9", ".", ".", "."},
                {".", ".", "7", ".", ".", ".", "2", "4", "."},
                {".", "6", "4", ".", "1", ".", "5", "9", "."},
                {".", "9", "8", ".", ".", ".", "3", ".", "."},
                {".", ".", ".", "8", ".", "3", ".", "2", "."},
                {".", ".", ".", ".", ".", ".", ".", ".", "6"},
                {".", ".", ".", "2", "7", "5", "9", ".", "."}
        };
        char[][] board = new char[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = original[i][j].toCharArray()[0];
            }
        }
        SudokuSolver sodokuSolver = new SudokuSolver();
        long start = System.currentTimeMillis();
        sodokuSolver.solveSudoku(board);
        System.out.println("use:" + (System.currentTimeMillis() - start) + "ms,count:" + sodokuSolver.count);
        SudokuSolver.printBoard(board);
    }
}
