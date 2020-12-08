package com.yuankui.leetcode.c50.q22

import org.junit.jupiter.api.Test
import java.util.*

/**
 * [
    "((()))",
    "(()())",
    "(())()",
    "()(())",
    "()()()"
   ]
 */
class Solution {
    fun generateParenthesis(n: Int): List<String> {
        val res: MutableList<String> = mutableListOf()
        
        fun add(current: Deque<Char>, index: Int, left: Int, right: Int) {
            if (index >= n * 2) {
                res.add(current.joinToString(""))
                return
            }

            // 加左括号
            if (left < n) {
                current.addLast('(')
                add(current, index + 1, left + 1, right)
                current.removeLast()
            }
            
            // 加右括号
            if (right < left) {
                current.addLast(')')
                add(current, index + 1, left, right + 1)
                current.removeLast()
            }
        }
        
        add(ArrayDeque(), 0, 0, 0)
        
        return res
    }
    
    @Test
    fun test() {
        val res = generateParenthesis(3)

        for (re in res) {
            println("re = ${re}")
        }
    }
}