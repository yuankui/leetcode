package com.yuankui.leetcode.c100.q73

class Solution {
    fun setZeroes(matrix: Array<IntArray>) {
        val ii = Array(matrix.size) { false }
        val jj = Array(matrix.first().size) { false}

        for (i in matrix.indices) {
            for (j in matrix[i].indices) {
                if (matrix[i][j] == 0) {
                    ii[i] = true
                    jj[j] = true
                }
            }
        }

        for (i in matrix.indices) {
            for (j in matrix[i].indices) {
                if (ii[i] || jj[j]) {
                    matrix[i][j] = 0
                }
            }
        }
    }
}