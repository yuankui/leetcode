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

    /**
     * 正则表达式: ^\s*(-|\+)?\d+(\.\d+)?((E|e)(-?)\d+)?
     *
     * DFA链接: https://dreampuf.github.io/GraphvizOnline/#digraph%20G%20%7B%0A%0A%20%20start%20-%3E%20S%0A%20%20S%20-%3E%20S%20%5Blabel%20%3D%20%22space%22%5D%0A%20%20%0A%20%20start%20-%3E%20p1%20%5Blabel%20%3D%20%22direct%22%5D%0A%20%20S%20-%3E%20p1%0A%20%20%0A%20%20%0A%20%20p1%20-%3E%20p2%0A%20%20p2%20-%3E%20p3%0A%20%20p1%20-%3E%20p4%0A%20%20p4%20-%3E%20p3%0A%20%20p1%20-%3E%20p3%20%5Blabel%20%3D%20%22direct%22%5D%0A%20%20%0A%20%20%0A%20%20p3%20-%3E%20d1%20%5Blabel%20%3D%20%22digit%22%5D%0A%20%20d1%20-%3E%20d1%20%5Blabel%20%3D%20%22digit%22%5D%0A%20%20%0A%20%20d1%20-%3E%20e1%20%5Blabel%20%3D%20%22%5C%22.%5C%22%22%5D%0A%20%20e1%20-%3E%20e2%20%5Blabel%20%3D%20%22digit%22%5D%0A%20%20e2%20-%3E%20e2%20%5Blabel%20%3D%20%22digit%22%5D%0A%20%20%0A%20%20%0A%20%20d1%20-%3E%20f%20%5Blabel%20%3D%20%22direct%22%5D%0A%20%20e2%20-%3E%20f%0A%20%20%0A%20%20%0A%20%20f%20-%3E%20end%20%0A%20%20%0A%20%20end%20%5Bshape%20%3D%20doublecircle%5D%0A%20%20%0A%7D
     */
}