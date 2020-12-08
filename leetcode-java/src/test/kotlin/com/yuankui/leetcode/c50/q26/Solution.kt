package com.yuankui.leetcode.c50.q26

import org.junit.jupiter.api.Test

class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        var removed = 0

        var last: Int? = null
        
        for (i in nums.indices) {
            val num = nums[i]
            
            // 与上一个相等
            if (num == last) {
                removed += 1
                continue
            }
            
            last = num
            nums[i-removed] = num
        }
        return nums.size - removed
    }
    
    @Test
    fun test() {
        val input = intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)
        val removed = this.removeDuplicates(input)

        println("removed = ${removed}")
        println("input = ${input.toList()}")


    }
}