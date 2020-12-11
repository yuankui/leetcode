package com.yuankui.leetcode.c100.q72

import org.junit.jupiter.api.Test

class Solution {
    fun minDistance(word1: String, word2: String): Int {
        val f = Array(word1.length + 1) { i ->
            Array(word2.length + 1) { j ->
                if (i == 0) j else if (j == 0) i else Int.MAX_VALUE
            }
        }

        for (i in 1..word1.length) {
            for (j in 1..word2.length) {
                if (word1[i-1] != word2[j-1]) {
                    val min = listOf<Int>(f[i - 1][j] + 1, f[i][j - 1] + 1, f[i - 1][j - 1] + 1).min()!!
                    f[i][j] = min
                } else {
                    f[i][j] = f[i - 1][j - 1]
                }
            }
        }

        return f[word1.length][word2.length]
    }

    @Test
    fun test() {
        val res = this.minDistance("horse", "ros")
        println("res = ${res}")

    }
}