package com.zhangke.algorithms.leetcode.utils

object ListUtils {

    fun printList(list: List<List<String>>) {
        val builder = StringBuilder()
        builder.append('[')
        list.forEach {
            builder.append('[')
            builder.append(it.joinToString(","))
            builder.append(']')
            builder.append(',')
        }
        builder.append(']')
        println(builder.toString())
    }
}