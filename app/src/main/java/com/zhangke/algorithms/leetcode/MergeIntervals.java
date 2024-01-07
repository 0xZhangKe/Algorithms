package com.zhangke.algorithms.leetcode;

import com.zhangke.algorithms.leetcode.utils.ArrayUtils;

/**
 * 56. 合并区间
 * https://leetcode.cn/problems/merge-intervals/
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        int min;
        int max;
        int[] currentArray;
        int mergeCount = 0;
        int index = 0;
        while (index >= 0 && index < intervals.length) {
            if (intervals[index][0] == -1) {
                index++;
                continue;
            }
            currentArray = intervals[index];
            min = currentArray[0];
            max = currentArray[1];
            for (int j = 0; j < intervals.length; j++) {
                if (intervals[j][0] == -1) continue;
                if (index == j) continue;
                if (intervals[j][1] >= min && intervals[j][0] <= max) {
                    mergeCount++;
                    min = Math.min(min, intervals[j][0]);
                    max = Math.max(max, intervals[j][1]);
                    intervals[j][0] = -1;
                }
            }
            if (min != currentArray[0] || max != currentArray[1]) {
                currentArray[0] = min;
                currentArray[1] = max;
                continue;
            }
            index++;
        }
        int[][] resultArray = new int[intervals.length - mergeCount][];
        index = 0;
        for (int[] interval : intervals) {
            if (interval[0] == -1) continue;
            resultArray[index++] = interval;
        }
        return resultArray;
    }

    public static void main(String[] args) {
        MergeIntervals obj = new MergeIntervals();
        // [[1,3],[2,6],[8,10],[15,18]]
        int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
//        ArrayUtils.INSTANCE.printArray(obj.merge(intervals));
//        ArrayUtils.INSTANCE.printArray(obj.merge(new int[][]{{1, 4}, {4, 5}}));
//        ArrayUtils.INSTANCE.printArray(obj.merge(new int[][]{{1, 4}, {0, 2}, {3, 5}}));
//        ArrayUtils.INSTANCE.printArray(obj.merge(new int[][]{
//                {0, 0},
//                {1, 2},
//                {5, 5},
//                {2, 4},
//                {3, 3},
//                {5, 6},
//                {5, 6},
//                {4, 6},
//                {0, 0},
//                {1, 2},
//                {0, 2},
//                {4, 5}
//        }));
        //[[3,5],[0,0],[4,4],[0,2],[5,6],[4,5],[3,5],[1,3],[4,6],[4,6],[3,4]]
        ArrayUtils.INSTANCE.printArray(obj.merge(new int[][]{
                {3, 5},
                {0, 0},
                {4, 4},
                {0, 2},
                {5, 6},
                {4, 5},
                {3, 5},
                {1, 3},
                {4, 6},
                {3, 4}
        }));
    }
}
