package com.zhangke.algorithms.leetcode;

import com.zhangke.algorithms.leetcode.utils.ListUtils;

import java.util.*;

/**
 * 49. 字母异位词分组
 * <a href="https://leetcode.cn/problems/group-anagrams/submissions/">49. 字母异位词分组</a>
 * 首先设计一个算法，输入相同的 字母异位词分组 但不同的字符串输出相同的值，这里通过最字符串按照char顺序排序，然后输出排序后的字符串来实现。
 * 然后创建一个 key 为上述算法输出值，value 为 list 的数据结构，然后遍历输入列表并将item存入 list，最终这个 Map 的 value 就是结果。
 */
public class GroupAnagrams {

    public static void main(String[] args){
        GroupAnagrams ag = new GroupAnagrams();
        ListUtils.INSTANCE.printList(ag.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    private List<List<String>> groupAnagrams(String[] strs){
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String sorted = sortString(str);
            if (map.containsKey(sorted)) {
                map.get(sorted).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(sorted, list);
            }
        }
        return new ArrayList<>(map.values());
    }

    private String sortString(String str){
        char[] array = str.toCharArray();
        char temp;
        for (int i = 0; i < array.length - 1; i++){
            for (int j = i; j < array.length; j++){
                if (array[i] > array[j]){
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return String.valueOf(array);
    }
}
