package com.zhangke.algorithms

import kotlin.collections.ArrayList

class SortedList<E : Comparable<E>>() : AbstractMutableList<E>() {

    private val list = ArrayList<E>()

    override val size: Int = list.size

    override fun add(element: E): Boolean {
        return list.add(element).also { list.sort() }
    }

    override fun add(index: Int, element: E) {
        list.add(index, element)
        list.sort()
    }

    override fun removeAt(index: Int): E {
        return list.removeAt(index).also { list.sort() }
    }

    override fun set(index: Int, element: E): E {
        return list.set(index, element).also { list.sort() }
    }

    override fun get(index: Int): E {
        return list[index]
    }
}