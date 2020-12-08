package com.yuankui.leetcode.c100.q53

import org.junit.jupiter.api.Test

class Solution {
    fun maxSubArray(nums: IntArray): Int {
        var min = Math.min(0, nums[0])
        var sum = nums[0]
        var max = nums[0]

        for (n in nums.asSequence().drop(1)) {
            sum += n

            if (sum - min > max) {
                max = sum - min
            }

            if (sum < min) {
                min = sum
            }
        }

        return max
    }

    @Test
    fun test() {
        val res = this.maxSubArray(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4))
//        val res = this.maxSubArray(intArrayOf(-1))
//        val res = this.maxSubArray(intArrayOf(-1, -2))
//        val res = this.maxSubArray(intArrayOf(1, 2))
        println("res = ${res}")
    }
}