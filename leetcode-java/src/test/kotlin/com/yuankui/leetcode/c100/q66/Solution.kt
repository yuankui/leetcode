package com.yuankui.leetcode.c100.q66

import org.junit.jupiter.api.Test

class Solution {
    fun plusOne(digits: IntArray): IntArray {

        var plus = 1
        val res = mutableListOf<Int>()
        for (i in digits.indices.reversed()) {
            val num = digits[i]
            if (num + plus > 9) {
                plus = 1
                res.add(0)
            } else {
                res.add(num + plus)
                plus = 0
            }
        }
        if (plus > 0) {
            res.add(plus)
        }

        return res.reversed().toIntArray()
    }

    @Test
    fun test() {
        val input = intArrayOf(1, 2, 3)
        val res = this.plusOne(input)

        println("res = ${res.toList()}")
    }
}