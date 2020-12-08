package com.yuankui.leetcode.c50.q16

import org.junit.jupiter.api.Test

class Solution {
    fun threeSumClosest(nums: IntArray, target: Int): Int {

        nums.sort()

        var min = Int.MAX_VALUE
        var sum = 0
        
        for (i in nums.indices) {
            val a= nums[i]

            // pointer
            var pLeft = i + 1
            var pRight = nums.size - 1

            while (pLeft < pRight) {
                val left = nums[pLeft]
                val right = nums[pRight]
                val delta = Math.abs(left + right + a - target)
                if (delta < min) {
                    min = delta
                    sum = left + right + a
                }
                
                if (left + right + a - target == 0) {
                    return left + right + a
                } else if (left + right + a - target < 0) {
                    pLeft += 1
                } else {
                    pRight -= 1
                }
            }
        }
        return sum
    }
    
    
    @Test
    fun test() {
        val array = intArrayOf(0, 1, 2)
        val target = 3
        val threeSumClosest = this.threeSumClosest(array, target)

        println("threeSumClosest = ${threeSumClosest}")
    }
}