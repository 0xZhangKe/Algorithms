package com.zhangke.algorithms

import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
class User(val name: String)

@Serializable
class Box<T>(val contents: T)

@Serializable
class Data(
    val a: Box<Int>,
    val b: Box<Project>
)

enum class Status { SUPPORTED }

@Serializable
data class Project(val name: String, val status: Status)

@Serializable
object Single {

    var name = "zhangke"
}

fun main() {
    val intSerializer: KSerializer<Int> = Int.serializer()
    println(intSerializer.descriptor)
}
