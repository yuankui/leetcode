package com.yuankui.leetcode

import org.junit.jupiter.api.Test

class Q0014LongestCommonPrefix {
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.size == 0) {
            return ""
        }
        val minLen = strs.map { it.length }.min()!!

        for (i in 0 until minLen) {
            val distinct = strs.map { it[i] }.distinct()
            if (distinct.size > 1) {
                return strs[0].substring(0, i)
            }
        }
        return strs[0].substring(0, minLen)
    }
    
    @Test
    fun test1() {
        val test = Q0014LongestCommonPrefix()
        val prefix = test.longestCommonPrefix(arrayOf("flower","flow","flight"))
        println("prefix = $prefix")
    }
}