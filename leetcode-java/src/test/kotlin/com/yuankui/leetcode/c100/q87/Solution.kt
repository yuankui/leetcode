package com.yuankui.leetcode.c100.q87

import org.junit.jupiter.api.Test

class Solution {
    fun isScramble(s1: String, s2: String): Boolean {
        if (s1.length != s2.length) return false;
        val len = s1.length

        val f: Array<Array<Array<Boolean>>> = Array(len + 1) {
            Array(len + 1) {
                Array(len + 1) { k ->
                    k == 0
                }
            }
        }

        for (l in 1..len) {
            for (i in 0..(len - l)) {
                for (j in 0..(len - l)) {
                    k@ for (k in 0 until l) {
                        // 相等
                        if (s1.substring(i, i + l) == s2.substring(j, j + l)) {
                            f[i][j][l] = true
                            break
                        }

                        if (f[i][j][k] && f[i + k][j + k][l - k]) {
                            f[i][j][l] = true
                            break
                        }

                        if (f[i][j + (l - k)][k] && f[i + k][j][l - k]) {
                            f[i][j][l] = true
                            break@k
                        }
                    }
                    if (f[i][j][l]) {
                        println("i => $i, j => $j, l => $l")
                    }
                }
            }
        }
        return f[0][0][len]
    }

    @Test
    fun test() {
        val res = this.isScramble("a", "b")
//        val res = this.isScramble("great", "rgeat")
        println("res = ${res}")
    }
}