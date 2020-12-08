package com.yuankui.leetcode.c50.q39

import org.junit.jupiter.api.Test

class CombinationSum {

    @Test
    fun test() {
//        val res = this.combinationSum(intArrayOf(2, 7, 6, 3, 5, 1), 9)
        val res = this.combinationSum(intArrayOf(2, 3, 6, 7), 7)

//        val res = this.combinationSum(intArrayOf(2), 1)
        println("res = ${res}")

    }

    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val f = mutableMapOf<Int, Sequence<Sequence<Int>>>()
        candidates.sort()
        val size = candidates.size
        
        fun find(i: Int, remain: Int): Sequence<Sequence<Int>> {
            if (remain == 0) {
                return sequenceOf(emptySequence())
            }
            if (f[remain] != null) {
                return f[remain]!!
            }
            var res = emptySequence<Sequence<Int>>()
            for (j in i until size) {
                val value = candidates[j]
                if (remain - value < 0) {
                    break
                }
                
                val lists = find(i, remain - value)
                val plan = lists.map { list -> 
                    list + value
                }
                res += plan
            }
            f[remain] = res
            return res
        }

        val res = find(0, target)

        return res.map { it.toList() }
                .distinctBy { 
                    it.sorted().toList()
                }
                .toList()
    }


}