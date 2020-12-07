package com.yuankui.leetcode.q47

class Solution {
    fun permuteUnique(nums: IntArray): List<List<Int>> {
        nums.sort()
        
        val res = mutableListOf<List<Int>>()

        val valueCount = nums.groupBy { it }
                .mapValues { it.value.size }
                .toMutableMap()

        fun fill(set: MutableSet<Int>, list: MutableList<Int>) {
            if (list.size == nums.size) {
                res.add(list.toList())
                return
            }

            for (v in valueCount.keys) {

            }
        }

        fill(mutableSetOf(), mutableListOf())

        return res
    }
}