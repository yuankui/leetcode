package com.yuankui.leetcode.c100.q74

import org.junit.jupiter.api.Test

class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        if (matrix.isEmpty()) return false
        val width = matrix.first().size
        val height = matrix.size
        val total = width * height

        var l = 0
        var r = total -1
        fun getNum(i: Int): Int {
            return matrix[i / width][i % width]
        }
        while (l <= r) {
            val mid = l + (r - l) / 2
            val midValue = getNum(mid)

            if (target < midValue) {
                r = mid - 1
            } else if (target > midValue) {
                l = mid + 1
            } else {
                return true
            }
        }
        return false
    }

    @Test
    fun test() {
        val input = arrayOf(
                intArrayOf(1, 3, 5, 7),
                intArrayOf(10, 11, 16, 20),
                intArrayOf(23, 30, 34, 60)
        )
        for (i in 0..69) {
            if (this.searchMatrix(input, i)) {
                println("i = ${i}")
            }
        }
    }
}