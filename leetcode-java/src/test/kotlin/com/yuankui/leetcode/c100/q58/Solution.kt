package com.yuankui.leetcode.c100.q58

import org.junit.jupiter.api.Test

class Solution {
    fun lengthOfLastWord(s: String): Int {
        var lastSpaceIndex = -1
        
        var lastLen = 0
        for (i in s.indices) {
            val c = s[i]
            if (c == ' ') {
                if (i - 1 - lastSpaceIndex != 0)
                    lastLen = i - 1 - lastSpaceIndex
                lastSpaceIndex = i 
            }
        }
        if (lastSpaceIndex != s.length - 1) {
            return s.length - 1 - lastSpaceIndex
        }
        
        return lastLen
    }

    @Test
    fun test() {
//        val res = this.lengthOfLastWord("hello world2")
        val res = this.lengthOfLastWord("b   a    ")
        
        println("res = ${res}")
    }
}