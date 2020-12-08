package com.yuankui.leetcode.c50.q32

import org.junit.jupiter.api.Test
import java.util.Stack

class Stack {
    fun longestValidParentheses(s: String): Int {
        var max = 0
        class State(val index: Int, val prevLen: Int)
        val stack: Stack<State> = Stack()
        var prevLen = 0
        
        for (i in s.indices) {
            val c = s[i]
            if (c == '(') {
                stack.push(State(i, prevLen))
                prevLen = 0
            } else {
                if (stack.isEmpty()) {
                    prevLen = 0
                    continue
                }

                val state = stack.pop()
                
                val len = i - state.index + 1 + state.prevLen
                prevLen = len
                
                if (len > max) {
                    max = len
                }
            }
        }

        return max
    }

    @Test
    fun test() {
        val ret0 = this.longestValidParentheses(")()())()()(")
        println("ret0 = ${ret0}")
    }
}