package com.zhangke.algorithms.leetcode;

import kotlin.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * 64. 最小路径和
 * <a href="https://leetcode.cn/problems/minimum-path-sum/">64. 最小路径和</a>
 * 用一个递归函数描述 x,y 到末尾的最小值，结束条件为 x,y 到了末尾，此时最小值是 grid[x][y].
 * x,y 点最小路径为左边分支的最小路径与下面分支的最小路径的最小值两者的最小值+grid[x][y].
 * 再加个缓存即可。
 */
public class MinimumPathSum {

    public static void main(String[] args) {
        MinimumPathSum sum = new MinimumPathSum();
        int[][] grid = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(sum.minPathSum(grid));
        System.out.println(sum.minPathSum(new int[][]{{1, 2, 3}, {4, 5, 6}}));
    }

    public int minPathSum(int[][] grid) {
        return minPathSum(grid, 0, 0, new HashMap<>());
    }

    private int minPathSum(int[][] grid, int x, int y, Map<Pair<Integer, Integer>, Integer> cache) {
        Pair<Integer, Integer> key = new Pair<>(x, y);
        if (cache.containsKey(key)) return cache.get(key);
        if (x == grid.length - 1 && y == grid[x].length - 1) {
            return grid[x][y];
        }
        int leftMinPathSum = Integer.MAX_VALUE;
        if (x < grid.length - 1) {
            leftMinPathSum = minPathSum(grid, x + 1, y, cache);
        }
        int bottomMinPathSum = Integer.MAX_VALUE;
        if (y < grid[x].length - 1) {
            bottomMinPathSum = minPathSum(grid, x, y + 1, cache);
        }
        int result = grid[x][y] + Math.min(leftMinPathSum, bottomMinPathSum);
        cache.put(key, result);
        return result;
    }
}
