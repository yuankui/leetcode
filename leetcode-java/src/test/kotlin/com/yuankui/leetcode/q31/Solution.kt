package com.yuankui.leetcode.q31

import org.junit.jupiter.api.Test
import java.util.*

/**
 * 思路：从最后一位，倒序找，遇到下降的数字，就路径上的"刚刚"比该数大的数字与该数交换位置，其余数字，升序排列
 * 
 * 如果没有遇到下降数字，就直接将整个翻转
 */
class Solution {
    fun nextPermutation(nums: IntArray): Unit {
        for (i in (nums.size -2) downTo 0) {
            val prev = nums[i + 1]
            val curr = nums[i]
            
            if (curr < prev) {
                // 找到刚刚比改数字大的
                var index = nums.size - 1
                var value: Int = 0
                for (j in nums.indices.reversed()) {
                    if (nums[j] > curr) {
                        index = j
                        value = nums[j]
                        break
                    }
                }
                
                // 交换
                nums[i] = value
                nums[index] = curr
                
                Arrays.sort(nums, i + 1, nums.size)
                return
            }
        }
        
        // 没有遇到倒序，直接反转
        return nums.reverse()
    }
    
    @Test
    fun test() {
        val input = intArrayOf(1, 2, 3)
        this.nextPermutation(input)
        println("input = ${input.toList()}")
        
        val input2 = intArrayOf(3,2,1)
        this.nextPermutation(input2)
        println("input2 = ${input2.toList()}")

        val input3 = intArrayOf(1, 4, 3, 2)
        this.nextPermutation(input3)
        println("input3 = ${input3.toList()}")
    }
}