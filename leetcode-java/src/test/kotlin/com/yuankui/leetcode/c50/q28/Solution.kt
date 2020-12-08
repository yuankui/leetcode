package com.yuankui.leetcode.c50.q28

import org.junit.jupiter.api.Test

class Solution {
    fun strStr(haystack: String, needle: String): Int {
        if (needle.isEmpty()) {
            return 0
        }
        val max = haystack.length - needle.length
        outer@ for (i in 0..max) {
            if (haystack.get(i) == needle.first()) {
                // 开始逐个比较
                for (j in needle.indices) {
                    if (haystack.get(i + j) != needle.get(j)) {
                        continue@outer
                    }
                }
                return i
            }
        }
        
        return -1
    }
    
    @Test
    fun test() {
        val strStr = this.strStr("hello", "ll")
        println("strStr = ${strStr}")

        println("this.strStr(\"aaaaa\", \"bba\") = ${this.strStr("aaaaa", "bba")}")
        

    }
}