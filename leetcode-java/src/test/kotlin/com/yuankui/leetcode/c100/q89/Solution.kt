package com.yuankui.leetcode.c100.q89

import org.junit.jupiter.api.Test

class Solution {
    fun grayCode(n: Int): List<Int> {

        for (i in 0 until Math.pow(2.0, n.toDouble()).toInt()) {
            
            val s = i.toString(2)
            for (j in 0 until n - s.length) {
                print("0")
            }
            println(s)
            
        }
        return emptyList()
    }

    @Test
    fun test() {
        this.grayCode(3)
    }
}