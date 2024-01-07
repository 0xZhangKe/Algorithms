package com.zhangke.algorithms.graph

import com.zhangke.algorithms.graph.adt.tree.SimpleTreeNode

fun generateIntSimpleTreeNode(): SimpleTreeNode<Int> {
    val node8 = SimpleTreeNode(8)
    val node9 = SimpleTreeNode(9)

    val node10 = SimpleTreeNode(10)
    val node11 = SimpleTreeNode(11)

    val node12 = SimpleTreeNode(12)
    val node13 = SimpleTreeNode(13)

    val node14 = SimpleTreeNode(14)
    val node15 = SimpleTreeNode(15)

    val node4 = SimpleTreeNode(4).apply {
        firstChild = node8
        nextSibling = node9
    }
    val node5 = SimpleTreeNode(5).apply {
        firstChild = node10
        nextSibling = node11
    }
    val node6 = SimpleTreeNode(6).apply {
        firstChild = node12
        nextSibling = node13
    }
    val node7 = SimpleTreeNode(7).apply {
        firstChild = node14
        nextSibling = node15
    }

    val node2 = SimpleTreeNode(2).apply {
        firstChild = node4
        nextSibling = node5
    }
    val node3 = SimpleTreeNode(3).apply {
        firstChild = node6
        nextSibling = node7
    }
    return SimpleTreeNode(1).apply {
        firstChild = node2
        nextSibling = node3
    }
}