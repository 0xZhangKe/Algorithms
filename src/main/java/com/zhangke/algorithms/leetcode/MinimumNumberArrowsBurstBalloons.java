package com.zhangke.algorithms.leetcode;

/**
 * 452. 用最少数量的箭引爆气球:
 * https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons/
 * Created by ZhangKe on 2021/3/12.
 */
public class MinimumNumberArrowsBurstBalloons {

    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) return 0;
        int index = 0;
        int count = 0;
        sort(points);
        while (index < points.length) {
            count++;
            int arrow = points[index][1];
            while (index < points.length && points[index][0] <= arrow) index++;
        }
        return count;
    }

    public void sort(int[][] data) {
        int[] tmp;
        int j;
        for (int p = 1; p < data.length; p++) {
            tmp = data[p];
            for (j = p; j > 0 && data[j - 1][1] > tmp[1]; j--) {
                data[j] = data[j - 1];
            }
            data[j] = tmp;
        }
    }

    public static void main(String[] args) {
        case1();
        case2();
        case3();
        case4();
        case5();
    }

    private static void case1() {
        MinimumNumberArrowsBurstBalloons m = new MinimumNumberArrowsBurstBalloons();
        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        System.out.println(m.findMinArrowShots(points));
    }

    private static void case2() {
        MinimumNumberArrowsBurstBalloons m = new MinimumNumberArrowsBurstBalloons();
        int[][] points = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        System.out.println(m.findMinArrowShots(points));
    }

    private static void case3() {
        MinimumNumberArrowsBurstBalloons m = new MinimumNumberArrowsBurstBalloons();
        int[][] points = {{1, 2}};
        System.out.println(m.findMinArrowShots(points));
    }

    private static void case4() {
        MinimumNumberArrowsBurstBalloons m = new MinimumNumberArrowsBurstBalloons();
        int[][] points = {{2, 3}, {2, 3}};
        System.out.println(m.findMinArrowShots(points));
    }

    private static void case5() {
        MinimumNumberArrowsBurstBalloons m = new MinimumNumberArrowsBurstBalloons();
        System.out.println(m.findMinArrowShots(null));
    }
}
