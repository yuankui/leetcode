package com.yuankui.leetcode.q34

import org.junit.jupiter.api.Test

class Solution {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        val index = nums.binarySearch(target)
        if (index < 0) {
            return intArrayOf(-1, -1)
        }

        val left = findItem(nums, index, target, -1) { it < 0 }
        val right = findItem(nums, index, target, 1) { it >= nums.size }

        return intArrayOf(left, right)
    }

    /**
     * 逐步放大
     */
    fun findItem(nums: IntArray,
                 start: Int,
                 target: Int,
                 direction: Int,
                 overflowChecker: (Int) -> Boolean
    ): Int {
        // 1. 找到最大放大倍数
        var dep = 1
        for (i in nums.indices) {
            val index = start + dep * direction
            if (overflowChecker(index)) break
            if (nums[index] != target) break
            dep *= 2
        }

        // 2. 逐级放小
        var acc = 0
        while (dep != 0) {
            dep /= 2
            val index = start + (acc + dep) * direction
            if (!overflowChecker(index) && nums[index] == target) {
                acc += dep
                continue
            }
        }

        return start + acc * direction
    }

    @Test
    fun test() {
        val res = this.searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 8)
        println("res = ${res.toList()}")

        val res1 = this.searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 6)
        println("res1 = ${res1.toList()}")

        val res2 = this.searchRange(intArrayOf(), 0)
        println("res2 = ${res2.toList()}")
    }

    @Test
    fun test1() {
        val arr = intArrayOf(5, 7, 7, 8, 8, 8, 8, 8, 8, 10)
        for (i in 3..8) {
            val res = this.findItem(arr, i, 8, 1) { it >= arr.size }
            println("${i} => ${res}")
        }
    }
}