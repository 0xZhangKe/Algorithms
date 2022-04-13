package com.zhangke.algorithms

import java.lang.StringBuilder
import java.util.*

class LimitedPriorityQueue<T>
@JvmOverloads constructor(private val maxSize: Int, comparator: Comparator<T>? = null) {

    private val queue = PriorityQueue(11, comparator)

    fun offer(e: T): T? {
        queue.offer(e)
        if (queue.size > maxSize) {
            return queue.poll()
        }
        return null
    }

    fun poll(): T? {
        return queue.poll()
    }

    fun size(): Int = queue.size

    fun toArray(): Array<T> {
        return queue.toArray() as Array<T>
    }

    override fun toString(): String {
        val builder = StringBuilder()
        builder.append("maxSize:")
        builder.append(maxSize)
        builder.append("[")
        for (i in queue) {
            builder.append(i)
            builder.append(", ")
        }
        builder.append("]")
        return builder.toString()
    }
}
