package com.yuankui.leetcode.c100.q71

import org.junit.jupiter.api.Test

class Split {
    fun simplifyPath(path: String): String {
        
        val stack = ArrayDeque<String>()
        
        path.split("/").forEach { token ->
            if (token == "..") {
                if (stack.isNotEmpty()) {
                    stack.removeLast()
                }
            } else if (token == ".") {
                // do nothing
            } else if (token == "") {
                // do nothing
            } else {
                stack.addLast(token)
            }
        }
        
        return stack.joinToString("/", "/")
    }

    @Test
    fun test() {
        val res = this.simplifyPath("/a//b////c/d//././/..")
        println("res = ${res}")
        
    }
}