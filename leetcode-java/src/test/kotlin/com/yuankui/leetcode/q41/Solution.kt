package com.yuankui.leetcode.q41

import org.junit.jupiter.api.Test

class Solution {
    fun firstMissingPositive(nums: IntArray): Int {
        nums.sort()

        var first = 0
        var last = 0
        for (num in nums) {
            if (num < 0) {
                continue
            }
            
            if (first == 0) {
                first = num
                if (first > 1) {
                    return 1
                }
            }

            if (num - last > 1) {
                return last + 1
            }
            last = num
        }
        
        return last + 1
    }
    
    @Test
    fun test() {
//        val res = this.firstMissingPositive(intArrayOf(1, 2, 0))
//        val res = this.firstMissingPositive(intArrayOf(3,4,-1,1))
        val res = this.firstMissingPositive(intArrayOf(7,8,9,11,12))
        println("res = ${res}")
        
    }
}