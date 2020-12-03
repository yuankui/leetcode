package com.yuankui.leetcode.q33

import org.junit.jupiter.api.Test

class BiSearch2 {
    fun search(nums: IntArray, target: Int): Int {
        // TODO 实现
        return 1
    }

    @Test
    fun test() {
        val arr = intArrayOf(4, 5, 6, 7, 0, 1, 2)
        for (i in arr) {
            val index = this.search(arr, i)

            println("${i} => ${index}")
        }
        
        val r1 = this.search(arr, 8)
        val r2 = this.search(arr, 3)

        println("r1 = ${r1}")
        println("r2 = ${r2}")
    }
}