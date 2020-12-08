package com.yuankui.leetcode.c50.q17

import org.junit.jupiter.api.Test

class Solution {
    fun letterCombinations(digits: String): List<String> {
        val map: Map<Char, String> = mapOf(
                '2' to "abc",
                '3' to "def",
                '4' to "ghi",
                '5' to "jkl",
                '6' to "mno",
                '7' to "pqrs",
                '8' to "tuv",
                '9' to "wxyz"
        )

        if (digits.isEmpty()) {
            return listOf()
        }
        var result: Iterable<String> = map[digits.first()]!!
                .toList()
                .map { it.toString() }
        
        if (digits.length == 1) {
            return result.toList()
        }

        for (i in 1 until digits.length) {
            val c = digits[i]
            val chars = map[c]!!
            result = result.flatMap { str ->
                 chars.map { "${str}${it}" }
            }
        }
        
        return result.toList()
    }
    
    @Test
    fun test() {
        val letterCombinations = this.letterCombinations("23")

        println("letterCombinations = ${letterCombinations}")

    }
}