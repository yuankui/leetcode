package com.yuankui.leetcode.q46

import org.junit.jupiter.api.Test

class Solution {
    fun permute(nums: IntArray): List<List<Int>> {

        val res = mutableListOf<List<Int>>()

        fun fill(set: MutableSet<Int>, list: MutableList<Int>) {
            if (set.size == nums.size) {
                res.add(list.toList())
                return
            }

            for (num in nums) {
                if (num in set) continue

                // 插入
                set.add(num)
                list.add(num)

                fill(set, list)

                set.remove(num)
                list.removeAt(list.size - 1)
            }
        }

        fill(mutableSetOf(), mutableListOf())

        return res
    }
    
    @Test
    fun test() {
        val res = this.permute(intArrayOf(1, 2, 3))
        println("res = ${res}")
        
    }
}