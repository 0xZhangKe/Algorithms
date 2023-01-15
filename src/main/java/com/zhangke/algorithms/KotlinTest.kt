package com.zhangke.algorithms

import java.net.URI
import java.net.URL

fun main() {
    val domainRegex = "\\w{1,63}(\\.\\w{1,63})+".toRegex()
    val target = "www.music.com.cn"
    println(domainRegex.find(target)?.value)
    println(URI("http://www.music.com.cn").host)
}

