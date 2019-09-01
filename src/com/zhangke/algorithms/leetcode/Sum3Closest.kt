package com.zhangke.algorithms.leetcode

/**
 * 16. 最接近的三数之和:
 * https://leetcode-cn.com/problems/3sum-closest/
 * Created by ZhangKe on 2019/8/29.
 */

class Solution {

    fun threeSumClosest(nums: IntArray, target: Int): Int {
        if (nums.size < 3) {
            var count = 0
            for (i in nums) {
                count += i
            }
            return count
        }
        java.util.Arrays.sort(nums)
        var L: Int
        var R: Int
        var sum: Int
        var divider = 0
        val len = nums.size
        var result = 0
        var min = Integer.MAX_VALUE
        for (i in 0 until len) {
//            if (i > 0 && nums[i] == nums[i - 1]) continue
            L = i + 1
            R = len - 1
            while (L < R) {
                sum = nums[i] + nums[L] + nums[R]
                divider = Math.abs(sum - target)
                if (min > divider) {
                    min = divider
                    result = sum
                }
//                while (L < R && nums[L] == nums[L + 1]) L++
//                while (L < R && nums[R] == nums[R - 1]) R--
                if (sum == target) {
                    return sum
                } else if (sum < target) {
                    L++
                } else {
                    R--
                }
            }
        }
        return result
    }
}

fun main(args: Array<String>) {
    val nums = IntArray(5)
    nums[0] = -1
    nums[1] = 0
    nums[2] = 1
    nums[3] = 1
    nums[4] = 55
    println(Solution().threeSumClosest(nums, 3))
}