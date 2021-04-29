package com.zhangke.algorithms.graph.adt.tree

import com.zhangke.algorithms.graph.generateIntSimpleTreeNode

/**
 * 树的深度优先遍历
 */
class DFS<T> {

    fun preOrderTraversal(node: SimpleTreeNode<T>, depth: Int) {
        println("depth:$depth, value:${node.v}")
        node.firstChild?.also { preOrderTraversal(it, depth + 1) }
        node.nextSibling?.also { preOrderTraversal(it, depth + 1) }
    }

    fun inOrderTraversal(node: SimpleTreeNode<T>, depth: Int) {
        node.firstChild?.also { inOrderTraversal(it, depth + 1) }
        println("depth:$depth, value:${node.v}")
        node.nextSibling?.also { inOrderTraversal(it, depth + 1) }
    }

    fun postOrderTraversal(node: SimpleTreeNode<T>, depth: Int) {
        node.firstChild?.also { postOrderTraversal(it, depth + 1) }
        node.nextSibling?.also { postOrderTraversal(it, depth + 1) }
        println("depth:$depth, value:${node.v}")
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val node = generateIntSimpleTreeNode()
            val traversal = DFS<Int>()
            println("preOrderTraversal：")
            traversal.preOrderTraversal(node, 0)
            println("inOrderTraversal：")
            traversal.inOrderTraversal(node, 0)
            println("postOrderTraversal：")
            traversal.postOrderTraversal(node, 0)
        }
    }
}