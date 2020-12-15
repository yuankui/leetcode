package com.yuankui.leetcode.c100.q85

import org.junit.jupiter.api.Test

class Solution {
    fun maximalRectangle(matrix: Array<CharArray>): Int {
        val h = Array(matrix.size) { IntArray(matrix.first().size) { 0 } }

        var maxSize = 0
        for (i in matrix.indices) {
            for (j in matrix.first().indices) {
                // 计算柱子
                if (matrix[i][j] == '0') {
                    h[i][j] = 0
                } else {
                    val up = if (i - 1 >= 0) h[i-1][j] else 0
                    h[i][j] = up + 1
                }

                // 枚举柱子
                var minHeight = h[i][j]
                if(minHeight > maxSize) maxSize = minHeight
                for (jj in j downTo 0) {
                    if (h[i][jj] == 0) break
                    minHeight = Math.min(minHeight, h[i][jj])
                    if ((j - jj + 1) * minHeight > maxSize) {
                        maxSize = (j - jj + 1) * minHeight
                    }
                }
            }
        }

        return maxSize
    }

    @Test
    fun test() {
        val input = arrayOf(
                "10100".toCharArray(),
                "10111".toCharArray(),
                "11111".toCharArray(),
                "10010".toCharArray(),
        )

        val res = this.maximalRectangle(input)
        println("res = ${res}")
    }
}