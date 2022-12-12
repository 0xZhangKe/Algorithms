package com.zhangke.algorithms.leetcode.utils

object ArrayUtils {

    fun printArray(array: Array<IntArray>) {
        StringBuilder().apply {
            array.forEach {
                append('[')
                append(it.joinToString(", "))
                append(']')
                append('\n')
            }
        }.let { println(it) }
    }

    fun printArray(array: Array<Array<*>>) {
        StringBuilder().apply {
            array.forEach {
                append('[')
                append(it.joinToString(", "))
                append(']')
            }
        }.let { println(it) }
    }
}