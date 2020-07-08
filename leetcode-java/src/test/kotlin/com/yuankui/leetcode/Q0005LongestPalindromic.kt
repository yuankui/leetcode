package com.yuankui.leetcode

import org.junit.jupiter.api.Test

class Q0005LongestPalindromic {
    fun longestPalindrome(s: String): String {
        var max = 0
        var maxString = ""

        // 奇数个
        for (middle in s.indices) {
            for (i in s.indices) {
                if (middle - i < 0 || middle + i > s.length - 1) {
                    break
                }

                if (s[middle - i] != s[middle + i]) {
                    break
                }

                if (i * 2 + 1 > max) {
                    max = i * 2 + 1
                    maxString = s.substring(middle - i, middle + i + 1)
                }
            }
        }

        // 偶数个
        for (left in 0 until s.length - 1) {
            if (s[left] != s[left + 1]) {
                continue
            }
            for (len in s.indices) {
                if (left - len < 0 || left + 1 + len > s.length - 1) {
                    break
                }

                if (s[left - len] != s[left + 1 + len]) {
                    break
                }

                if (len * 2 + 2 > max) {
                    max = len * 2 + 2
                    maxString = s.substring(left - len, left + 1 + len + 1)
                }
            }
        }


        return maxString
    }

    @Test
    fun test1() {
        val s = "babad"

        val res = Q0005LongestPalindromic().longestPalindrome(s)
        println("res = $res")
    }
}