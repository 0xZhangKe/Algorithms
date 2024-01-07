package com.zhangke.algorithms

class LimitedSortedList<E : Comparable<E>>(private val max: Int) {

    private val list = SortedList<E>()

    val size: Int = list.size

    fun add(element: E): E? {
        list.add(element)
        return trim()
    }

    fun get(index: Int): E {
        return list[index]
    }

    fun iterator(): Iterator<E> = list.iterator()

    private fun trim(): E? {
        if (list.size > max) {
            return list.removeAt(0)
        }
        return null
    }
}