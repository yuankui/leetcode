package com.yuankui.leetcode.q32

import org.junit.jupiter.api.Test

class Stack {
    fun longestValidParentheses(s: String): Int {
        var max = 0

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