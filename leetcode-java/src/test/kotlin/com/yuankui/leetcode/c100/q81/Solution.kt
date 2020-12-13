package com.yuankui.leetcode.c100.q81

import org.junit.jupiter.api.Test

class Solution {
    fun search(nums: IntArray, target: Int): Boolean {
        if (nums.isEmpty()) {
            return false
        }
        var l = 0
        var r = nums.size - 1

        while (l < r) {
            val mid = l + (r - l) / 2
            val m = nums[mid]
            val left = nums[l]
            val right = nums[r]
            if (target == left) return true
            if (target == right) return true
            if (target == m) return true

            if (m == left) {
                // 1. 直接顺次相等
                if (left == right) {
                    l += 1
                }
                // 2. 先升，后降    
                else if (target < m) {
                    l = mid + 1
                } else {
                    return false
                }
            } else if (m < left) {
                if (target > m && target < right) {
                    l = mid + 1
                } else {
                    r = mid - 1
                }
            } else {
                if (target > left && target < m) {
                    r = mid - 1
                } else {
                    l = mid + 1
                }
            }
        }

        return nums[l] == target
    }

    @Test
    fun test() {
        for (i in 0..12) {
            val res = this.search(intArrayOf(2, 5, 6, 0, 0, 1, 2), i)
            if (res) {
                println("i = ${i}")
            }
        }
    }

    @Test
    fun test2() {
//        val res = this.search(intArrayOf(1, 3, 1, 1, 1), 3)
        val res = this.search(intArrayOf(2, 2, 2, 0, 0, 1), 0)

//        val res = this.search(intArrayOf(1, 1, 3, 1), 3)
        println("res = ${res}")
    }
}