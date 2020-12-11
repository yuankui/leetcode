package com.yuankui.leetcode.c100.q71

import org.junit.jupiter.api.Test
import java.lang.StringBuilder

class Solution {
    fun simplifyPath(path: String): String {
        val stack = ArrayDeque<String>()
        
        val wordAcc = StringBuilder()
        var dotCount = 0
        
        var last = '/'
        path.asSequence().drop(1).forEach { char ->
            if (char.isLetter()) {
                wordAcc.append(char)
            }
            if (char == '.') {
                dotCount += 1
                if (dotCount > 1) {
                    // 到上级目录
                    if (stack.isNotEmpty()) stack.removeLast()
                    dotCount = 0
                }
            }
            if (char == '/') {
                if (wordAcc.isNotEmpty())
                    stack.addLast(wordAcc.toString())
                wordAcc.clear()
                dotCount = 0
            }
            
            last = char
        }
        
        if (wordAcc.isNotEmpty()) {
            stack.addLast(wordAcc.toString())
        } else if (dotCount > 1) {
            stack.removeLast()
        }
        
        return stack.joinToString("/", prefix = "/")
    }

    @Test
    fun test() {
//        val res = this.simplifyPath("/home/")
//        val res = this.simplifyPath("/a/../../b/../c//.//")
        val res = this.simplifyPath("/a//b////c/d//././/..")
//        val res = this.simplifyPath("/a/./b/../../c/")
//        val res = this.simplifyPath("/home//foo/")
//        val res = this.simplifyPath("/../")
        println("res = ${res}")
    }
}