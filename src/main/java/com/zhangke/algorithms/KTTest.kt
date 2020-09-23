package com.zhangke.algorithms

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.functions.BiFunction
import java.util.concurrent.LinkedBlockingDeque

fun main(){
    val queue = LinkedBlockingDeque<Int>()
    Thread{
        while (true){
            val v = queue.takeFirst()
            println(v)
        }
    }.start()
    Thread{
        for(i in 0 .. 10){
            Thread.sleep(200)
            queue.offerFirst(i)
        }
    }.start()
}

fun main1() {
    val firstSource = getObs().toObservable()
    val secondSource = Observable.create<Int> { it.onNext(20) }
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