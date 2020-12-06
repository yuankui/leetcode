package com.yuankui.leetcode.q47

class Solution {
    fun permuteUnique(nums: IntArray): List<List<Int>> {
        nums.sort()
        
        val res = mutableListOf<List<Int>>()

        fun fill(set: MutableSet<Int>, list: MutableList<Int>, max: Int) {
            if (set.size == nums.size) {
                res.add(list.toList())
                return
            }

            for (i in nums.indices) {
                val num = nums[i]
                if (num in set) continue

                // 插入
                set.add(num)
                list.add(num)

                fill(set, list)
                

                set.remove(num)
                list.removeAt(list.size - 1)
            }
        }

        fill(mutableSetOf(), mutableListOf(), Int.MIN_VALUE)

        return res
    }
}