package com.zhangke.algorithms.leetcode

import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

/**
 * 17.电话号码的字母组合
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * Created by ZhangKe on 2019/9/2.
 */
class LetterCombinationsPhone {

    data class TreeNode(val value: Char, var childs: List<TreeNode>? = null, var parent: TreeNode? = null)

    class Solution {
        fun letterCombinations(digits: String): List<String> {
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
            var treeNode: TreeNode? = null
            var curTreeNodes: List<TreeNode>? = null
            var arrayTmp: CharArray
            for (i in digitArray.indices) {
                arrayTmp = map.get(digitArray[i])!!
                val list = mutableListOf<TreeNode>()
                for (c in arrayTmp) {
                    list.add(TreeNode(c))
                }
                if (i == 0) {
                    treeNode = TreeNode('-', list)
                } else {
                    for (node in curTreeNodes!!) {
                        for(n in list){
                            n.parent = node
                        }
                        node.childs = list
                    }
                }
                curTreeNodes = list
            }
            val list = ArrayList<String>()
            dfs(treeNode!!, list)
            return list
        }

        fun dfs(treeNode: TreeNode, list: ArrayList<String>) {
            if (treeNode.childs.isNullOrEmpty()) {
                val builder = StringBuilder()
                getTreeNodeValues(treeNode, builder)
                list.add(builder.toString())
            } else {
                for (n in treeNode.childs!!) {
                    dfs(n, list)
                }
            }
        }

        fun getTreeNodeValues(treeNode: TreeNode, builder: StringBuilder){
            builder.append(treeNode.value)
            treeNode.parent?.let { getTreeNodeValues(it, builder) }
        }
    }
}

fun main(args: Array<String>) {
    println(LetterCombinationsPhone.Solution().letterCombinations("234"))
}