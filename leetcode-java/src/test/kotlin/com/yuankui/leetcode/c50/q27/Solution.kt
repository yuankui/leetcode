package com.yuankui.leetcode.c50.q27

class Solution {
    fun removeElement(nums: IntArray, target: Int): Int {
        var removed = 0
        for (i in nums.indices) {
            val value = nums[i]
            if (value == target) {
                removed += 1
            } else {
                nums[i-removed] = value
            }
        }

        return nums.size - removed
    }
}