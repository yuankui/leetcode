package com.yuankui.leetcode.q32

import org.junit.jupiter.api.Test

class Solution {
    fun longestValidParentheses(s: String): Int {
        
        var max = 0
        
        outer@ for (i in s.indices) {
            if (s[i] != '(') {
                continue
            }
            var weight = 1
            
            for (j in (i + 1) until s.length) {
                val c = s[j]
                if (c == '(') {
                    weight += 1
                } else {
                    weight -= 1
                }
                
                if (weight < 0) {
                    continue@outer
                }
                
                if (weight > s.length - j) {
                    continue@outer
                }
                if (weight == 0) {
                    max = Math.max(max, j - i + 1)
                    println("${s.substring(i, j + 1)}")
                }
            }
        }
        
        return max
    }
    
    @Test
    fun test() {
        val ret = this.longestValidParentheses("(()")
        println("ret = ${ret}")

        val ret2 = this.longestValidParentheses(")()())")
        println("ret2 = ${ret2}")
    }
}