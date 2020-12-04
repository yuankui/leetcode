package com.yuankui.leetcode.q34

import org.junit.jupiter.api.Test

class Solution {
    fun searchRange(nums: IntArray, target: Int): IntArray {

        return intArrayOf()
    }

    fun biSearch(nums: IntArray, start: Int, end: Int, target: Int) : Int {
        var l = start
        var r = end
        while (l < r) {
            val index = (l + r) / 2
            val midValue = nums[index]

            if (r - l == 1) {
                return if (midValue == target) index else -1
            }
            if (midValue == target) {
                return index
            } else if (midValue < target) {
                l = index
            } else {
                r = index
            }
        }
        return -1
    }

    @Test
    fun test() {
        val nums = IntRange(0, 18).toList().toIntArray()

        for (num in nums) {
            val index = biSearch(nums, 0, nums.size, num)
            println("${num} => ${index}")
        }

        val res = biSearch(nums, 0, nums.size, 20)
        println("res = ${res}")

    }
}