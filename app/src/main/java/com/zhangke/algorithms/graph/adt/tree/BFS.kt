package com.zhangke.algorithms.graph.adt.tree

import com.zhangke.algorithms.graph.generateIntSimpleTreeNode
import java.util.*

class BFS<T> {

    fun traversalRecursive(node: SimpleTreeNode<T>) {
        traversalRecursive(listOf(node), 0)
    }

    private fun traversalRecursive(nodes: List<SimpleTreeNode<T>>, depth: Int) {
        if (nodes.isEmpty()) return
        val list = mutableListOf<SimpleTreeNode<T>>()
        nodes.forEach { node ->
            println("depth:$depth, value:${node.v}")
            node.firstChild?.also { list += it }
            node.nextSibling?.also { list += it }
        }
        traversalRecursive(list, depth + 1)
    }

    fun traversal(node: SimpleTreeNode<T>) {
        val queue = ArrayDeque<SimpleTreeNode<T>>()
        queue.add(node)
        while (queue.isNotEmpty()) {
            val n = queue.poll()
            println("value:${n.v}")
            n.firstChild?.also { queue.add(it) }
            n.nextSibling?.also { queue.add(it) }
        }
    }

    fun traversalWithDepth(node: SimpleTreeNode<T>) {
        val queue = ArrayDeque<Pair<SimpleTreeNode<T>, Int>>()
        queue.add(Pair(node, 0))
        while (queue.isNotEmpty()) {
            val (n, depth) = queue.poll()
            println("depth:${depth}, value:${n.v}")
            n.firstChild?.also { queue.add(Pair(it, depth + 1)) }
            n.nextSibling?.also { queue.add(Pair(it, depth + 1)) }
        }
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val node = generateIntSimpleTreeNode()
            val traversal = BFS<Int>()
            println("traversalRecursive:")
            traversal.traversalRecursive(node)
            println("traversal:")
            traversal.traversal(node)
            println("traversalWithDepth:")
            traversal.traversalWithDepth(node)
        }
    }
}