package com.yuankui.leetcode

import org.junit.jupiter.api.Test

class Q0015Sum3 {
    fun threeSum(nums: IntArray): List<List<Int>> {
        // value -> list(index)
        val map = mutableMapOf<Int, MutableList<Int>>()

        val groups = nums.groupBy { it }
                .mapValues { it.value.size }
        
        groups.entries.forEachIndexed {
            index: Int, entry: Map.Entry<Int, Int> -> 
            val value = entry.key
            val count = entry.value
        }
        nums.forEachIndexed { index: Int, num: Int ->
            val list = map.get(num)
            if (list == null) {
                map.put(num, mutableListOf(index))
            } else {
                list.add(index)
            }
        }

        val res = mutableSetOf<List<Int>>()
        
        for (i in nums.indices) {
            for (j in i + 1 until nums.size) {
                val target = -(nums[i] + nums[j])
                val list = map.get(target) ?: continue
                list.forEach { 
                    if (it > i && it > j) {
                        res.add(listOf(nums[i], nums[j], nums[it]).sorted())
                    }
                }
            }
        }
        
        return res.toList()
    }
    
    @Test
    fun test1() {
        val run = Q0015Sum3()
        val res = run.threeSum(intArrayOf(-1, 0, 1, 2, -1, -4))
        println("res = $res")

    }
}