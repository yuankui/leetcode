package com.yuankui.leetcode.c100.q80

import org.junit.jupiter.api.Test

class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        var removed = 0
        var list = mutableListOf<Int>()

        for (i in nums.indices) {
            val num = nums[i]
            if (list.isEmpty()) {
                list.add(num)
                nums[i - removed] = num
                continue
            }

            if (list.last() != num) {
                list.clear()
                list.add(num)
                nums[i - removed] = num
                continue
            }

            if (list.size >= 2) {
                removed += 1
                continue
            } else {
                list.add(num)
                nums[i - removed] = num
            }
        }

        return nums.size - removed
    }

    @Test
    fun test() {
        val input = intArrayOf(0, 0, 1, 1, 1, 1, 2, 3, 3)
//        val input = intArrayOf(1, 1, 1, 2, 2, 3)
        val res = this.removeDuplicates(input)

        val out = input.asSequence().take(res).toList()
        println("out = ${out}")


    }
}