package com.yuankui.leetcode

import org.junit.jupiter.api.Test

class Q003LongestSubstring {
    fun lengthOfLongestSubstring(s: String): Int {
        var max = 0
        for (i in s.indices) {
            val a = mutableSetOf<Char>()
            for (j in i until s.length) {
                val c = s[j]
                if (c in a) {
                    break
                }
                val len = j - i + 1
                a.add(c)
                if (len > max) {
                    max = len
                }
            }
        }
        return max
    }

    @Test
    fun test() {
        println(lengthOfLongestSubstring("abcabcbb"))
        println(lengthOfLongestSubstring("bbbbb"))
        println(lengthOfLongestSubstring("pwwkew"))
    }
}