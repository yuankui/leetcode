package com.yuankui.leetcode.q20

import com.yuankui.leetcode.addTo
import org.junit.jupiter.api.Test

class Solution {
    fun isValid(s: String): Boolean {
        val close = mapOf(
                ')' to '(',
                ']' to '[',
                '}' to '{'
        )

        val deque = ArrayDeque<Char>()
        for (c in s) {
            if (c !in close) {
                deque.addLast(c)
                continue
            }

            val last: Char
            try {
                last = deque.removeLast()
            } catch (e: Exception) {
                return false
            }


            val couple = close[c]
            if (last != couple) {
                return false
            }
        }

        return deque.isEmpty()
    }

    @Test
    fun test() {
        val booleans = mutableListOf<Boolean>()
        this.isValid("(){}}{").addTo(booleans)
        this.isValid("]").addTo(booleans)
        this.isValid("()").addTo(booleans)
        this.isValid("()[]{}").addTo(booleans)
        this.isValid("(]").addTo(booleans)
        this.isValid("([)]").addTo(booleans)
        this.isValid("{[]}").addTo(booleans)

        println("ints = ${booleans}")

    }
}