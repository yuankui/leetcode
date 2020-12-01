package com.yuankui.leetcode

import org.junit.jupiter.api.Test

class Q0015Sum3 {
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()

        val map: MutableMap<Int, MutableSet<List<Int>>> = mutableMapOf()

        val solution: MutableSet<List<Int>> = mutableSetOf()
        
        for (i in 2 until nums.size) {
            // 将当前元素和签名所有元素组合，将组合加入到map中
            for (j in 0 until (i-2)) {
                val a = nums[i-1]
                val b = nums[j]
                val sum = a + b
                val list = map.getOrDefault(sum, mutableSetOf())
                list.add(listOf(a, b))
                map[sum] = list
            }

            val c = nums[i]
            val list = map[-c]
            if (list != null) {
                list.map { 
                    listOf(it[0], it[1], c)
                }.forEach {
                    solution.add(it)
                }
            }
        }
        
        return solution.toList()
    }
    
    @Test
    fun test1() {
        val run = Q0015Sum3()
        val res = run.threeSum(intArrayOf(-1,0,1,2,-1,-4))
        
        println("res = $res")

    }
}