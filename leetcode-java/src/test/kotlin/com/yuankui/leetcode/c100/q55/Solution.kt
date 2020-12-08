package com.yuankui.leetcode.c100.q55

import org.junit.jupiter.api.Test


class Solution {
    fun canJump(nums: IntArray): Boolean {
        var max = 0

        for (i in nums.indices) {
            if (i > max) {
                return false
            }
            val value = nums[i]

            if (i + value > max) {
                max = i + value
            }
        }
        return true
    }

    @Test
    fun test() {
//        val input = intArrayOf(2, 3, 1, 1, 4)
//        val input = intArrayOf(3, 2, 1, 0, 4)
        val input = intArrayOf(0)
        val res = this.canJump(input)
        println("res = ${res}")
    }
}