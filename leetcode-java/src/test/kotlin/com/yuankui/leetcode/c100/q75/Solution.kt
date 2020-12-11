package com.yuankui.leetcode.c100.q75

import org.junit.jupiter.api.Test

class Solution {
    fun sortColors(nums: IntArray): Unit {
        var p0 = 0
        var p2 = nums.size - 1

        var p = 0

        fun swap(i: Int, j: Int) {
            val tmp = nums[i]
            nums[i] = nums[j]
            nums[j] = tmp
        }
        while (p <= p2) {
            val num = nums[p]
            if (num == 2) {
                swap(p2, p)
                p2 -= 1
            } else if (num == 0 && p != p0) {
                swap(p0, p)
                p0 += 1
            } else {
                p += 1
            }
        }
    }

    @Test
    fun test() {
        val input = intArrayOf(2, 0, 2, 1, 1, 0)



        this.sortColors(input)

        println("input.toList() = ${input.toList()}")
    }
}