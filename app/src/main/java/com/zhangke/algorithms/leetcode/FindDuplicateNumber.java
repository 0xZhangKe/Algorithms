package com.zhangke.algorithms.leetcode;

/**
 * 287. 寻找重复数:
 * https://leetcode-cn.com/problems/find-the-duplicate-number/
 * Created by ZhangKe on 2021/3/8.
 */
public class FindDuplicateNumber {

    public int findDuplicate(int[] nums) {
        int fast = 0;
        int slow = 0;
        do {
            fast = nums[nums[fast]];
            slow = nums[slow];
        } while (fast != slow);
        fast = 0;
        do {
            fast = nums[fast];
            slow = nums[slow];
        } while (fast != slow);
        return slow;
    }

    public static void main(String[] args) {
        case1();
        case2();
        case3();
        case4();
        case5();
        case6();
    }

    private static void case1() {
        FindDuplicateNumber fdn = new FindDuplicateNumber();
        int[] nums = {1, 3, 4, 2, 2};
        System.out.println(fdn.findDuplicate(nums));
    }

    private static void case2() {
        FindDuplicateNumber fdn = new FindDuplicateNumber();
        int[] nums = {3, 1, 3, 4, 2};
        System.out.println(fdn.findDuplicate(nums));
    }

    private static void case3() {
        FindDuplicateNumber fdn = new FindDuplicateNumber();
        int[] nums = {1, 1};
        System.out.println(fdn.findDuplicate(nums));
    }

    private static void case4() {
        FindDuplicateNumber fdn = new FindDuplicateNumber();
        int[] nums = {1, 1, 2};
        System.out.println(fdn.findDuplicate(nums));
    }

    private static void case5() {
        FindDuplicateNumber fdn = new FindDuplicateNumber();
        int[] nums = {1, 3, 4, 2, 1};
        System.out.println(fdn.findDuplicate(nums));
    }

    private static void case6() {
        FindDuplicateNumber fdn = new FindDuplicateNumber();
        int[] nums = {4, 3, 1, 4, 2};
        System.out.println(fdn.findDuplicate(nums));
    }
}
