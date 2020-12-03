package com.yuankui.leetcode.q33

class Solution {
    fun search(nums: IntArray, target: Int): Int {
        for (i in nums.indices) {
            val value = nums[i]
            if (value == target) {
                return i
            }
        }
        
        return -1
    }
}