package com.yuankui.leetcode

import org.junit.jupiter.api.Test

class Q0015Sum3 {
    fun threeSum(nums: IntArray): List<List<Int>> {
        if (nums.size < 3) {
            return listOf()
        }
        
        nums.sort()

        val solution: MutableSet<List<Int>> = mutableSetOf()
        
        for (i in nums.indices) {
            val a= nums[i]
            
            // pointer
            var pLeft = i + 1
            var pRight = nums.size - 1
            
            while (pLeft < pRight) {
                val left = nums[pLeft]
                val right = nums[pRight]
                if (left + right + a == 0) {
                    solution.add(listOf(a, left, right))
                    if (left == nums[pLeft + 1]) {
                        pLeft += 1
                    } else if (right == nums[pRight - 1]) {
                        pRight -= 1
                    } else {
                        pLeft += 1
                        pRight -= 1
                    }
                } else if (left + right + a < 0) {
                    pLeft += 1
                } else {
                    pRight -= 1
                }
            }
        }
        return solution.toList()
    }
    
    @Test
    fun test1() {
        val run = Q0015Sum3()
        val res = run.threeSum(intArrayOf(-1, 0, 1, 2, -1, -4))
        
        println("res = $res")

    }
}