package com.yuankui.leetcode.q45

import org.junit.jupiter.api.Test

class Eager {
    fun jump(nums: IntArray): Int {
        var step = 0
        var maxPos = 0
        var end = 0
        
        for (i in (0 until nums.size - 1)) {
            maxPos = Math.max(maxPos, i + nums[i])
            
            if (i == end) {
                step += 1
                end = maxPos

                if (end >= nums.size) {
                    return step
                }
            }
        }
        return step
    }

    @Test
    fun test() {
//        val res = this.jump(intArrayOf(2, 3, 1, 1, 4))
//        val res = this.jump(intArrayOf(2, 3, 0, 1, 4))
//        val res = this.jump(intArrayOf(0))
//        val res = this.jump(intArrayOf(2, 3, 1, 1, 4))
        val res = this.jump(intArrayOf(1, 2, 3, 4, 5))
        
        
        println("res = ${res}")

    }
}