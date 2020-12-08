package com.yuankui.leetcode.c100.q64

import org.junit.jupiter.api.Test

class Solution {
    fun minPathSum(grid: Array<IntArray>): Int {
        val height = grid.size
        val width = grid.first().size

        val f = Array(grid.size) { IntArray(grid.first().size) { 0 } }

        for (i in 0 until height) {
            for (j in 0 until width) {
                // 初始化
                if (i == 0) {
                    val last = if (j-1 >=0) f[i][j-1] else 0
                    f[i][j] = grid[i][j] + last
                    continue
                }

                f[i][j] = grid[i][j] + f[i - 1][j]
                if (j - 1 >= 0) {
                    if (grid[i][j] + f[i][j - 1] < f[i][j]) {
                        f[i][j] = grid[i][j] + f[i][j - 1]
                    }
                }
            }
        }

        return f[height - 1][width - 1]
    }

    @Test
    fun test() {
//        val input = arrayOf(
//                intArrayOf(1, 3, 1),
//                intArrayOf(1, 5, 1),
//                intArrayOf(4, 2, 1),
//        )
        val input = arrayOf(
                intArrayOf(1, 2),
                intArrayOf(1, 1),
        )
        val res = this.minPathSum(input)
        println("res = ${res}")
    }
}