@file:JvmName("Util")

package com.zhangke.algorithms.leetcode

import java.lang.StringBuilder

/**
 * Created by ZhangKe on 2019/9/12.
 */

class ListNode @JvmOverloads constructor(val value: Int, var next: ListNode? = null)

fun buildListNode(node: ListNode, start: Int, end: Int) {
    if (start >= end) {
        return
    }
    node.next = ListNode(start + 1)
    buildListNode(node.next!!, start + 1, end)
}

fun printNode(node: ListNode) {
    println(StringBuilder().apply {
        var curNode: ListNode? = node
        while (curNode != null) {
            append(curNode.value)
            curNode = curNode.next
            if (curNode != null) {
                append("->")
            }
        }
    })
}

fun printNode(node: com.zhangke.algorithms.data.ListNode) {
    println(StringBuilder().apply {
        var curNode: com.zhangke.algorithms.data.ListNode? = node
        while (curNode != null) {
            append(curNode.`val`)
            curNode = curNode.next
            if (curNode != null) {
                append("->")
            }
        }
    })
}

/**
 * 打印 List，
 * 每个元素都占用一行
 */
fun printListElementWithLine(list: List<*>) {
    println("[")
    list.forEach { println("    \"$it\",") }
    println("]")
}

fun printArray(array: IntArray){
    val builder = StringBuilder()
    for (index in array.indices) {
        if (index == 0) {
            builder.append("[")
        }
        builder.append(array[index])
        if (index != array.size - 1) {
            builder.append(",")
        } else {
            builder.append("]")
        }
    }
    println(builder.toString())
}