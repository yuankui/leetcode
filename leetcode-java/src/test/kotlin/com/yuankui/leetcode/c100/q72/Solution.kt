package com.yuankui.leetcode.c100.q72

import org.junit.jupiter.api.Test

class Solution {
    fun minDistance(word1: String, word2: String): Int {
        val f = Array(word1.length) { i ->
            Array(word2.length) { j ->
                if (i == 0) j else if (j == 0) i else Int.MAX_VALUE
            }
        }

        for (i in 1 until word1.length) {
            for (j in 1 until word2.length) {
                if (word1[i] != word2[j]) {
                    val min = listOf<Int>(f[i - 1][j] + 1, f[i][j - 1] + 1, f[i - 1][j - 1]).max()!!
                    f[i][j] = min
                } else {
                    f[i][j] = f[i - 1][j - 1]
                }
                for (ints in f) {
                    for (int in ints) {
                        if (int == Int.MAX_VALUE) {
                            print("-1,")
                        } else {
                            print("${int},")
                        }
                    }
                    println()
                }
            }
        }

        return f[word1.length - 1][word2.length - 1]
    }

    @Test
    fun test() {
        val res = this.minDistance("horse", "ros")
        println("res = ${res}")

    }
}