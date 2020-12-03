package com.yuankui.leetcode.q32

import org.junit.jupiter.api.Test

class DP {
    fun longestValidParentheses(s: String): Int {
        var max = 0
        val f = IntArray(s.length) { 0 }

        for (i in 1 until s.length) {
            val c = s[i]
            if (c == '(') {
                continue
            }

            val prev = s[i - 1]
            if (prev == '(') {
                val prev = if (i - 2 >= 0) f[i - 2] else 0
                f[i] = prev + 2
            } else {
                val len = f[i - 1]

                if (i - len - 1 >= 0 && s[i - len - 1] == '(') {

                    val a = if (i - 2 - len >= 0)
                        f[i - 1 - len - 1]
                    else
                        0

                    val b = if (i - 1 >= 0) f[i - 1] else 0

                    f[i] = 1 + b + 1 + a
                }
            }

            if (f[i] > max) {
                max = f[i]
            }
        }

        return max
    }

    @Test
    fun test() {
        
        val ret0 = this.longestValidParentheses("(()())")
        println("ret0 = ${ret0}")
        
        this.longestValidParentheses("())")

        val ret1 = this.longestValidParentheses("()(())")
        println("ret1 = ${ret1}")

        val ret = this.longestValidParentheses("(()")
        println("ret = ${ret}")

        val ret2 = this.longestValidParentheses(")()())")
        println("ret2 = ${ret2}")


    }
}