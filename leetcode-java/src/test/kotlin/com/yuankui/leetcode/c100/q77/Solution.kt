package com.yuankui.leetcode.c100.q77

import org.junit.jupiter.api.Test

class Solution {
    fun combine(n: Int, k: Int): List<List<Int>> {
        val res = mutableListOf<List<Int>>()

        val list = mutableListOf<Int>()

        fun find(left: Int, min: Int) {
            if (left == 0) {
                res.add(list.toList())
                return
            }

            for (i in min..n) {
                // 选择i
                list.add(i)
                find(left -1, i + 1)
                list.removeAt(list.size - 1)
            }
        }

        find(k, 1)

        return res
    }

    @Test
    fun test() {
        val res = this.combine(4, 2)
        println("res = ${res}")
    }
}