package com.zhangke.algorithms

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.functions.BiFunction
import java.lang.RuntimeException

fun main() {
    val firstSource = Observable.create<Int> {
        it.onError(RuntimeException("666"))
    }
    val secondSource = Observable.create<Int> { it.onNext(20) }
    val zipper = BiFunction<Int, Int, Int> { p1, p2 -> p1 + p2 }
    Observable.zip(firstSource, secondSource, zipper)
        .subscribe({
            println(it)
        }, {
            it.printStackTrace()
        })
}