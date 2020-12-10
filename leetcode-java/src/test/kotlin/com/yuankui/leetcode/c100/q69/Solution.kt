package com.yuankui.leetcode.c100.q69

import org.junit.jupiter.api.Test

class Solution {
    fun mySqrt(x: Int): Int {
        if (x <= 1) return x
        var left = 1L
        var right = x.toLong()
        while (true) {
            if (right - left <= 1) {
                break
            }
            val mid: Long = ((left + right) / 2).toLong()
            if (mid * mid < x) {
                left = mid
            } else if (mid * mid > x) {
                right = mid
            } else {
                return mid.toInt()
            }
        }
        return left.toInt()
    }

    @Test
    fun test() {
        val r = this.mySqrt(4)
//        val r = this.mySqrt(8)
//        val r = this.mySqrt(2147395600)
        println("r = ${r}")
    }
}