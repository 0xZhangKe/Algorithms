package com.zhangke.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args) {

        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        System.out.println(spiralMatrix.spiralOrder(matrix));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>(matrix.length * matrix[0].length);
        int leftEdge = -1, topEdge = -1;
        int rightEdge = matrix[0].length;
        int bottomEdge = matrix.length;
        // 0-idle, 1-to right, 2-to bottom, 3-toLeft, 4-to top.
        int state = 0;
        int i = 0, j = 0;
        while (i > leftEdge && i < rightEdge && j > topEdge && j < bottomEdge) {
            if (state == 0 || state == 4) {
                for (i = leftEdge + 1; i < rightEdge; i++) {
                    result.add(matrix[j][i]);
                }
                i--;
                state = 1;
                topEdge++;
                if (j == topEdge) j++;
            } else if (state == 1) {
                for (j = topEdge + 1; j < bottomEdge; j++) {
                    result.add(matrix[j][i]);
                }
                j--;
                state = 2;
                rightEdge--;
                if (i == rightEdge) i--;
            } else if (state == 2) {
                for (i = rightEdge - 1; i > leftEdge; i--) {
                    result.add(matrix[j][i]);
                }
                i++;
                state = 3;
                bottomEdge--;
                if (j == bottomEdge) j--;
            } else {
                for (j = bottomEdge - 1; j > topEdge; j--) {
                    result.add(matrix[j][i]);
                }
                j++;
                state = 4;
                leftEdge++;
                if (i == leftEdge) i++;
            }
        }
        return result;
    }
}
