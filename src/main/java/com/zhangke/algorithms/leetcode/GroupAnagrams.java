package com.zhangke.algorithms.leetcode;

import com.zhangke.algorithms.leetcode.utils.ListUtils;

import java.util.*;

/**
 * 49. 字母异位词分组
 * <a href="https://leetcode.cn/problems/group-anagrams/submissions/">49. 字母异位词分组</a>
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
