package com.zhangke.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 51.N皇后问题：
 * https://leetcode-cn.com/problems/n-queens/submissions/
 * 当前位置所在列 index = i
 * 当前位置所在的右上到左下的列表 index = i + j
 * 当前位置所在的左上到右下的列表 index = N - 1 - j + i
 * Created by ZhangKe on 2020/4/2.
 */
public class NQueens {

    public List<List<String>> solveNQueens(int n) {
        //当前列中是否已有皇后
        boolean[] column = new boolean[n];
        //右上到左下列中是否有皇后
        boolean[] rl = new boolean[2 * n - 1];
        //左上到右下列中是否有皇后
        boolean[] lr = new boolean[2 * n - 1];
        //每行皇后的位置
        int[] board = new int[n];
        List<List<String>> result = new ArrayList<>(n);
        backtrace(n, 0, column, rl, lr, board, result);
        return result;
    }

    /**
     * 开始递归
     *
     * @param row 行号，从 0 开始
     * @return true-遍历结束，false-继续
     */
    private void backtrace(int n, int row, boolean[] column, boolean[] rl, boolean[] lr, int[] board, List<List<String>> result) {
        if (row >= n) {
            List<String> boardList = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                StringBuilder rowBuilder = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    rowBuilder.append(board[i] == j ? "Q" : ".");
                }
                boardList.add(rowBuilder.toString());
            }
            result.add(boardList);
        }
        for (int columnIndex = 0; columnIndex < n; columnIndex++) {
            if (!column[columnIndex] && !rl[row + columnIndex] && !lr[n - 1 - row + columnIndex]) {
                //无皇后
                column[columnIndex] = rl[row + columnIndex] = lr[n - 1 - row + columnIndex] = true;
                board[row] = columnIndex;
                backtrace(n, row + 1, column, rl, lr, board, result);
                column[columnIndex] = rl[row + columnIndex] = lr[n - 1 - row + columnIndex] = false;
            }
        }
    }

    public void printBoard(List<List<String>> board) {
        for (int row = 0; row < board.size(); row++) {
            StringBuilder rowBuilder = new StringBuilder();
            rowBuilder.append("[");
            List<String> rowItem = board.get(row);
            for (int column = 0; column < rowItem.size(); column++) {
                rowBuilder.append(rowItem.get(column));
                if (column != rowItem.size() - 1) {
                    rowBuilder.append(",\n");
                }
            }
            rowBuilder.append("]");
            if (row != board.size() - 1) {
                rowBuilder.append("\n");
            }
            System.out.println(rowBuilder.toString());
        }
    }

    public static void main(String[] args) {
        NQueens eq = new NQueens();
        eq.printBoard(eq.solveNQueens(4));
    }
}
