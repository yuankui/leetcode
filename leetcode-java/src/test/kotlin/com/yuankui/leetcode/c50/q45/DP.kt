package com.yuankui.leetcode.c50.q45

import org.junit.jupiter.api.Test

/**
 * # 动态规划
 *
 *
 */
class DP {
    fun jump(nums: IntArray): Int {
        val f: MutableMap<Int, Int> = mutableMapOf()

        // 初始化
        for (index in nums.indices) {
            f[index] = nums.size
        }

        f[nums.size - 1] = 0

        val indices = nums.indices.reversed()
                .asSequence()
                .drop(1)

        for (i in indices) {
            val num = nums[i]
            for (step in 1..num) {
                if (i + step >= nums.size) break
                if (1 + f[i + step]!! < f[i]!!) {
                    f[i] = 1 + f[i + step]!!
                }
            }
        }

        return f[0]!!
    }

    @Test
    fun test() {
//        val res = this.jump(intArrayOf(2, 3, 1, 1, 4))
        val res = this.jump(intArrayOf(2, 3, 0, 1, 4))
        println("res = ${res}")

    }
}