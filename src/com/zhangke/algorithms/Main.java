package com.zhangke.algorithms;

public class Main {

    public static void main(String[] args) {
        int[] numArray1 = {1, 10, 20};
        int[] numArray2 = {2, 8, 9};
//        System.out.println(findMedianSortedArrays(numArray1, numArray2));
        Util.printArray(merge(numArray1, numArray2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int[] mid;
//        if (nums1.length == 0) {
//            mid = getMid(nums2);
//        } else if (nums2.length == 0) {
//            mid = getMid(nums1);
//        } else {
//            int[] mid1 = getMid(nums1);
//            int[] mid2 = getMid(nums2);
//            mid = new int[mid1.length + mid2.length];
//            int start;
//            for (start = 0; start < mid1.length; start++) {
//                mid[start] = mid1[start];
//            }
//            for (int i = 0; i < mid2.length; i++) {
//                mid[start + i] = mid2[i];
//            }
//        }
//        int[] realMid;
//        if (mid.length <= 2) {
//            realMid = mid;
//        } else {
//            sortArray(mid);
//            realMid = getMid(mid);
//        }
//        if (realMid.length == 1) {
//            return realMid[0];
//        } else {
//            return (realMid[0] + realMid[1]) / 2.0;
//        }

        int[] merged = merge(nums1, nums2);
        if (merged.length % 2 == 0) {
            //偶数
            return (merged[merged.length / 2] + merged[merged.length / 2 - 1]) / 2.0;
        } else {
            return merged[merged.length / 2];
        }
    }

    private static int[] getMid(int[] nums) {
        if (nums.length % 2 == 0) {
            //偶数
            return new int[]{nums[nums.length / 2], nums[nums.length / 2 - 1]};
        } else {
            return new int[]{nums[nums.length / 2]};
        }
    }

    private static void sortArray(int[] data) {
        int tmp;
        int j;
        for (int p = 1; p < data.length; p++) {
            tmp = data[p];
            for (j = p; j > 0 && data[j - 1] > tmp; j--) {
                data[j] = data[j - 1];
            }
            data[j] = tmp;
        }
    }

    /**
     * 合并两个已排序数组
     */
    private static int[] merge(int[] data1, int[] data2) {
        if (data1.length == 0) {
            return data2;
        }
        if (data2.length == 0) {
            return data1;
        }
        int[] mergedData = new int[data1.length + data2.length];
        int index = 0;
        int num1;
        int num2;
        for (int i = 0, j = 0; i < data1.length || j < data2.length; ) {
            if (i >= data1.length) {
                mergedData[index++] = data2[j++];
            } else if (j >= data2.length) {
                mergedData[index++] = data1[i++];
            }else{
                num1 = data1[i];
                num2 = data2[j];
                if (num1 < num2) {
                    mergedData[index++] = num1;
                    i++;
                } else {
                    mergedData[index++] = num2;
                    j++;
                }
            }
        }
        return mergedData;
    }
}
