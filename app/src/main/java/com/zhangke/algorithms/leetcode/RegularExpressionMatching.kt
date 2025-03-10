package com.zhangke.algorithms.leetcode

fun main() {
    println(isMatch("aaa", "ab*a*c*a")) // true
    println(isMatch("a", "ab*")) // true
    println(isMatch("abcaaaaaaabaabcabac", ".*ab.a.*a*a*.*b*b*")) // true
    println(isMatch("ab", ".*c")) // true
}

private fun isMatch(s: String, p: String): Boolean {
    if (s == p) return true
    var pIndex = 0
    var sIndex = 0
    while (pIndex < p.length) {
        if (pIndex < p.length - 1 && p[pIndex + 1] == '*') {
            val leftRegex = p.substring(pIndex + 2)
            for (i in 0..(s.length - sIndex)) {
                val newRegex = buildString {
                    repeat(i) { append(p[pIndex]) }
                    append(leftRegex)
                }
                val newText = if (sIndex > s.lastIndex) "" else s.substring(sIndex)
                if (isMatch(newText, newRegex)) return true
            }
            return false
        }
        if (sIndex > s.lastIndex || s[sIndex] != p[pIndex] && p[pIndex] != '.') return false
        sIndex++
        pIndex++
    }
    return sIndex >= s.length
}
