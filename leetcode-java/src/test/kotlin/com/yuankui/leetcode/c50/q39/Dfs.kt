package com.yuankui.leetcode.c50.q39

import org.junit.jupiter.api.Test

class Dfs {

    @Test
    fun test() {
//        val res = this.combinationSum(intArrayOf(2, 7, 6, 3, 5, 1), 9)
        val res = this.combinationSum(intArrayOf(2, 3, 6, 7), 7)

//        val res = this.combinationSum(intArrayOf(2), 1)
        println("res = ${res}")

    }

    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val res = mutableListOf<List<Int>>()
        candidates.sort()
        
        fun dfs(currentList: MutableList<Int>, target: Int, index: Int) {
            if (target == 0) {
                res.add(currentList.toList())
            }
            
            val value = candidates[index]
            
            if (value <= target) {
                // 1. 选择当前
                currentList.add(value)
                dfs(currentList, target - value, index)
                currentList.removeAt(currentList.size - 1)

                // 2. 选择后面
                if (index + 1 < candidates.size) {
                    dfs(currentList, target, index + 1)
                }
            }
        }
        
        dfs(mutableListOf(), target, 0)
        return res
    }


}