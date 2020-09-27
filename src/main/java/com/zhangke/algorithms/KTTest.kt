package com.zhangke.algorithms

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.functions.BiFunction

fun main() {
    val firstSource = getObs().toObservable()
    val secondSource = Observable.create<Int> { it.onError(java.lang.RuntimeException("111")) }
    val zipper = BiFunction<Int, Int, Int> { p1, p2 -> p1 + p2 }
    Observable.zip(firstSource, secondSource, zipper)
        .subscribe({
            println(it)
        }, {
            it.printStackTrace()
        })
}

fun getObs(): Single<Int> {
    val single = Single.fromCallable {
        10
    }
        .map {
            it
        }
    return Single.create { emitter ->
        single.subscribe({
            //            emitter.onSuccess(it)
            emitter.onError(RuntimeException("666"))
        }, {
            emitter.onError(it)
        })
    }
}