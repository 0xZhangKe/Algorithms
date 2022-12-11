package com.zhangke.algorithms.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 1898. 可移除字符的最大数目
 * https://leetcode.cn/problems/maximum-number-of-removable-characters/
 */
public class MaximumNumberOfRemovableCharacters {

    public int maximumRemovals(String s, String p, int[] removable) {
        char[] sArray = s.toCharArray();
        char[] pArray = p.toCharArray();
        int len = removable.length;
        int leftEdge = 0;
        int rightEdge = len - 1;
        int pivot = len / 2;
        while (pivot >= 1 && pivot < len) {
            int removableLength = pivot + 1;
            if (isSubSequence(sArray, pArray, removable, removableLength)) {
                leftEdge = pivot;
                if (removableLength == len) {
                    pivot++;
                    break;
                }
                if (isSubSequence(sArray, pArray, removable, removableLength + 1)) {
                    pivot = pivot + (rightEdge + 1 - pivot) / 2;
                } else {
                    pivot++;
                    break;
                }
            } else {
                rightEdge = pivot;
                if (isSubSequence(sArray, pArray, removable, removableLength - 1)) {
                    break;
                } else {
                    pivot = leftEdge + (pivot - leftEdge) / 2;
                }
            }
        }
        return pivot;
    }

    private boolean isSubSequence(char[] source, char[] sub, int[] removeIndexArray, int removableLength) {
        int subCurrentIndex = 0;
        Set<Integer> removeIndexSet = new HashSet<>(removableLength);
        for (int i = 0; i < removableLength; i++) {
            removeIndexSet.add(removeIndexArray[i]);
        }
        for (int i = 0; i < source.length; i++) {
            if (removeIndexSet.contains(i)) continue;
            char c = source[i];
            if (sub[subCurrentIndex] == c) subCurrentIndex++;
            if (subCurrentIndex == sub.length) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        MaximumNumberOfRemovableCharacters obj = new MaximumNumberOfRemovableCharacters();

//        System.out.println(obj.maximumRemovals("abcacb", "ab", new int[]{3, 1, 0}));
//        System.out.println(obj.maximumRemovals("abcbddddd", "abcd", new int[]{3, 2, 1, 4, 5, 6}));
//        System.out.println(obj.maximumRemovals("qobftgcueho", "obue", new int[]{5, 3, 0, 6, 4, 9, 10, 7, 2, 8}));
//        System.out.println(obj.maximumRemovals("abcbddddd", "abcd", new int[]{3, 2, 1, 4, 5, 6}));
//        System.out.println(obj.maximumRemovals("qlevcvgzfpryiqlwy", "qlecfqlw", new int[]{12,5}));
//        System.out.println(obj.maximumRemovals(
//                "kkwiypfzruadoeyfzogmpslfbvrumcrogouomuaidyhqvlaumguqcipcbfkdnp",
//                "kkiyaogslrroadmcb",
//                new int[]{52,44,9,12,54,5,16,36,23,8,43,58,15,13,28,2,29,27,34,60,25,35,20,7,31,11,51,39,19,24,21,38,42,57,49,37,59,50}
//        ));
        //"cdijywkabpzxph"
        //"iwpph"
        //[11,0,1,8,6]
        System.out.println(obj.maximumRemovals("cdijywkabpzxph", "iwpph", new int[]{11,0,1,8,6}));
    }

    private static void assertRemoveIndex() {
        MaximumNumberOfRemovableCharacters obj = new MaximumNumberOfRemovableCharacters();
//        int[] removable = new int[]{1, 2, 2, 3};
//        for (char c : obj.removeIndex("abcd".toCharArray(), removable, 0)) {
//            System.out.print(c);
//        }
//        System.out.println();
//        for (char c : obj.removeIndex("abcd".toCharArray(), removable, 1)) {
//            System.out.print(c);
//        }
//        System.out.println();
//        for (char c : obj.removeIndex("abcd".toCharArray(), removable, 2)) {
//            System.out.print(c);
//        }
    }

    private static void assertIsSubSequence() {
//        MaximumNumberOfRemovableCharacters obj = new MaximumNumberOfRemovableCharacters();
//        System.out.println(obj.isSubSequence("abcde".toCharArray(), "cd".toCharArray()));
//        System.out.println(obj.isSubSequence("abcde".toCharArray(), "ce".toCharArray()));
//        System.out.println(obj.isSubSequence("abcde".toCharArray(), "ae".toCharArray()));
//        System.out.println(obj.isSubSequence("abcde".toCharArray(), "e".toCharArray()));
//        System.out.println(obj.isSubSequence("abcde".toCharArray(), "a".toCharArray()));
//        System.out.println(obj.isSubSequence("abcde".toCharArray(), "aa".toCharArray()));
    }
}
