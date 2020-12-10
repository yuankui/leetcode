package com.yuankui.leetcode.c100.q70

import org.junit.jupiter.api.Test

class Solution {
    fun climbStairs(n: Int): Int {
        var l = 1
        var r = 2
        if (n == 1) return l
        if (n == 2) return r
        
        for (i in 3..n) {
            val t = l + r
            l = r
            r = t
        }
        
        return r
    }

    @Test
    fun test() {
        for (i in 1..20) {
            val res = this.climbStairs(i)
            println("${i} => ${res}")
        }
    }
}