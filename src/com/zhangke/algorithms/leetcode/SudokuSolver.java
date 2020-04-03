package com.zhangke.algorithms.leetcode;

/**
 * 37. 解数独:
 * https://leetcode-cn.com/problems/sudoku-solver/
 * Created by ZhangKe on 2020/3/26.
 */
public class SudokuSolver {

    public void solveSudoku(char[][] board) {

    }

    private void backtrack(int row, int column){

    }

    public static void main(String[] args){
        String[][] original = {
                {"5", "3", ".", ".", "7", ".", ".", ".", "."},
                {"6", ".", ".", "1", "9", "5", ".", ".", "."},
                {".", "9", "8", ".", ".", ".", ".", "6", "."},
                {"8", ".", ".", ".", "6", ".", ".", ".", "3"},
                {"4", ".", ".", "8", ".", "3", ".", ".", "1"},
                {"7", ".", ".", ".", "2", ".", ".", ".", "6"},
                {".", "6", ".", ".", ".", ".", "2", "8", "."},
                {".", ".", ".", "4", "1", "9", ".", ".", "5"},
                {".", ".", ".", ".", "8", ".", ".", "7", "9"}
        };
        char[][] board = new char[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = original[i][j].toCharArray()[0];
            }
        }
        SudokuSolver sodokuSolver = new SudokuSolver();
    }
}
