package com.zhangke.algorithms

import java.util.*

class LimitedQueue<E>(private val maxSize: Int) : Iterable<E> {

    private val queue = ArrayDeque<E>()

    fun offer(e: E): E? {
        queue.offer(e)
        return trimLimit()
    }

    fun contains(e: E): Boolean = queue.contains(e)

    fun size(): Int = queue.size

    fun poll(): E? = queue.poll()

    fun remove(e: E): Boolean = queue.remove(e)

    fun clear() {
        queue.clear()
    }

    override fun iterator(): Iterator<E> {
        return queue.iterator()
    }

    private fun trimLimit(): E? {
        if (queue.size > maxSize) {
            return queue.poll()
        }
        return null
    }

    override fun hashCode(): Int {
        return 31 * maxSize + queue.hashCode()
    }

    override fun toString(): String {
        return "limit:$maxSize, data:$queue"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other?.javaClass != javaClass) return false
        other as LimitedQueue<*>
        return other.maxSize == maxSize && other.queue == queue
    }
}
