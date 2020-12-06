package com.yuankui.leetcode.q38

import org.junit.jupiter.api.Test

class CountAndSay {
    fun countAndSay(n: Int): String {
        var last = "1"
        for (i in 1 until n) {
            last = desc(last)
        }
        return last
    }
    
    fun desc(str: String): String {
        var lastChar = 'a'
        var lastCount = 0
        
        val res = StringBuilder()
        
        for (c in str) {
            if (c == lastChar) {
                lastCount += 1
                continue
            }
            
            if (lastCount > 0) {
                res.append("${lastCount}${lastChar}")
            }
            lastCount = 1
            lastChar = c
        }

        if (lastCount > 0) {
            res.append("${lastCount}${lastChar}")
        }
        
        return res.toString()
    }
    
    @Test
    fun test() {
        for (i in 1..10) {
            val res = countAndSay(i)
            println("res = ${res}")
        }
    }
}