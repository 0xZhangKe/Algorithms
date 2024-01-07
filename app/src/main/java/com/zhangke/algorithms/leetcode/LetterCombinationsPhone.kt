package com.zhangke.algorithms.leetcode

import java.lang.StringBuilder
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

/**
 * 17.电话号码的字母组合
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * Created by ZhangKe on 2019/9/2.
 */
class LetterCombinationsPhone {

    class Solution {

        fun letterCombinations(digits: String): List<String> {
            if (digits.isEmpty()) return listOf()
            val map = HashMap<Char, CharArray>(8).apply {
                put('2', charArrayOf('a', 'b', 'c'))
                put('3', charArrayOf('d', 'e', 'f'))
                put('4', charArrayOf('g', 'h', 'i'))
                put('5', charArrayOf('j', 'k', 'l'))
                put('6', charArrayOf('m', 'n', 'o'))
                put('7', charArrayOf('p', 'q', 'r', 's'))
                put('8', charArrayOf('t', 'u', 'v'))
                put('9', charArrayOf('w', 'x', 'y', 'z'))
            }
            val digitArray = digits.toCharArray()
            val array = Array<CharArray?>(digitArray.size, { null })
            for (i in digitArray.indices) {
                array[i] = map[digitArray[i]]!!
            }
            val list = ArrayList<String>()
            dfs(array, -1, 0, list, java.util.Stack<Char>())
            return list
        }

        fun dfs(array: Array<CharArray?>, firstPositon: Int,
                secondPosition: Int, list: ArrayList<String>,
                stack: java.util.Stack<Char>) {
            if (array.size <= firstPositon || (firstPositon >= 0 && array[firstPositon]!!.size <= secondPosition)) return
            if (firstPositon >= 0) {
                stack.push(array[firstPositon]!![secondPosition])
            }
            if (array.size <= firstPositon + 1) {
                list.add(StringBuilder().apply {
                    val li = ArrayList<Char>()
                    val iterator = stack.iterator()
                    while (iterator.hasNext()) {
                        li.add(iterator.next())
                    }
                    for (c in li) {
                        append(c)
                    }
                }.toString())
            } else {
                for (i in 0..4) {
                    dfs(array, firstPositon + 1, i, list, stack)
                }
            }
            if (!stack.isEmpty()) {
                stack.pop()
            }
        }
    }
}

fun main(args: Array<String>) {
    println(LetterCombinationsPhone.Solution().letterCombinations("234"))
}