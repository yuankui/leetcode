package com.yuankui.leetcode.c100.q76

import org.junit.jupiter.api.Test

class Solution {
    fun minWindow(s: String, t: String): String {
        var l = 0
        var r = 0
        val charSet = t.groupBy { it }
                .mapValues { it.value.size }

        val countMap = mutableMapOf<Char, Int>()

        val expectCharSet = charSet.keys.toMutableSet()

        for (i in s.indices) {

            val c = s[i]

            if (c !in charSet) {
                continue
            }
            val count = countMap[c] ?: 0
            countMap[c] = count + 1

            if (count >= charSet[c]?: 0) {
                expectCharSet.remove(c)
            }
            if (expectCharSet.size == 0) {
                r = i
                // 已经找到一个足够大的集合,现在开始扫描
                break
            }
        }

        if (expectCharSet.isNotEmpty()) {
            return ""
        }

        var min = Int.MAX_VALUE
        var minIndex = Pair(0, 0)

        // 开始移动
        while (true) {
            // 左边尽力右移
            while (true) {
                if (s[l] !in charSet) {
                    l += 1
                    continue
                }

                val count = countMap[s[l]] ?: 0
                val expCount = charSet[s[l]] ?: 0
                if (count > expCount) {
                    countMap[s[l]] = count - 1
                    l += 1
                } else {
                    break
                }
            }

            if (r -l < min) {
                min = r -l
                minIndex = Pair(l, r)
            }

            if (r == s.length - 1) {
                // 右边已经到边,则推出循环
                break
            }

            // 右指针尽力右移,知道遇到第一个charset元素

            r += 1
            while (true) {
                if (r >= s.length) break
                if (s[r] !in charSet && r < s.length - 1) {
                    r += 1
                    continue
                } else {
                    val count = countMap[s[r]] ?: 0
                    countMap[s[r]] = count + 1
                    break
                }
            }
        }


        return s.substring(l, r + 1)
    }

    @Test
    fun test() {

        val res = this.minWindow("A", "AA")
//        val res = this.minWindow("ADOBECODEBANC", "ABC")
        // "BANC"

        println("res = ${res}")
    }
}