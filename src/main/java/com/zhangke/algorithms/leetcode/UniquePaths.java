package com.zhangke.algorithms.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 62. 不同路径
 * <a href="https://leetcode.cn/problems/unique-paths/submissions/">62. 不同路径</a>
 * 当前位置距离重点的路径个数等于右边节点距离终点路径个数加下面节点距离终点个数。一个递归加个缓存即可。
 */
public class UniquePaths {

    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        System.out.println(uniquePaths.uniquePaths(3, 7));
        System.out.println(uniquePaths.uniquePaths(3, 2));
        System.out.println(uniquePaths.uniquePaths(7, 3));
        System.out.println(uniquePaths.uniquePaths(3, 3));
        System.out.println(uniquePaths.uniquePaths(23, 12));
    }

    public int uniquePaths(int m, int n) {
        return counter(m, n, 0, 0, new HashMap<>());
    }

    private int counter(int m, int n, int x, int y, Map<String, Integer> cache) {
        String key = x + ":" + y;
        if (cache.containsKey(key)) return cache.get(key);
        if (x == n - 1 && y == m - 1) return 1;
        int count = 0;
        if (x < n - 1) {
            count += counter(m, n, x + 1, y, cache);
        }
        if (y < m - 1) {
            count += counter(m, n, x, y + 1, cache);
        }
        cache.put(key, count);
        return count;
    }
}
