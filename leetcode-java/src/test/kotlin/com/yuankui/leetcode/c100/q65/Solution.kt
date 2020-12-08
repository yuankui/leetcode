package com.yuankui.leetcode.c100.q65

class Solution {
    fun isNumber(s: String): Boolean {
        val digits = ('0'..'9').toSet()
        val exp = setOf('e', 'E')
        val ops = setOf('-', '+')
        
        // 处理包含非法字符
        if (s.any { !(it in digits || it in exp || it in ops)}) {
            return false
        }
        
        // 处理中间包含空格
        if (s.trim().contains(' ')) {
            return false
        }
        
        // 连续包含正负号的
        for (i in 0 until s.length - 1) {
            if (s[i] in ops && s[i+1] in ops) return false
        }
        
        // todo
        
        
    }
}