package com.zhangke.algorithms.encode

import com.google.common.base.Charsets
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

fun main() {
    val keyValue = "69DAD813E13A40418B81863B59E65AC5"
    val en =
        "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"
    val text = """["com.asd.vdfb","com.dfjh.aksd"]"""
//    val encoded = encode(en, keyValue)
//    println(encoded)
    println(decode(en, keyValue))
}

private fun List<ByteArray>.toByteArray(): ByteArray {
    val totalSize = map { it.size }.reduce { acc, i -> acc + i }
    val array = ByteArray(totalSize)
    val curSize = 0
    forEach {
        it.copyInto(array, curSize, it.size)
    }
    return array
}

private fun encode(text: String, aesKey: String): String {
    val key = SecretKeySpec(aesKey.toByteArray(), "AES")
    val cipher = Cipher.getInstance("AES/ECB/PKCS5Padding")
    cipher.init(Cipher.ENCRYPT_MODE, key)
    val a = cipher.doFinal(text.toByteArray(Charsets.UTF_8))
    return com.zhangke.algorithms.encode.Base64.encodeToString(a, com.zhangke.algorithms.encode.Base64.NO_WRAP)
}

private fun decode(text: String, aesKey: String): String {
    val key = SecretKeySpec(aesKey.toByteArray(), "AES")
    val cipher = Cipher.getInstance("AES/ECB/PKCS5Padding")
    cipher.init(Cipher.DECRYPT_MODE, key)
    val base64Decoded = com.zhangke.algorithms.encode.Base64.decode(text, com.zhangke.algorithms.encode.Base64.NO_WRAP)
    return String(cipher.doFinal(base64Decoded), Charsets.UTF_8)
}