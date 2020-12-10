package com.yuankui.leetcode.c100.q67

import org.junit.jupiter.api.Test

class Solution {
    fun addBinary(a: String, b: String): String {
        var extra = 0
        val res = mutableListOf<Int>()
        for (i in 0 until (Math.max(a.length, b.length))) {
            val aa = if (a.length - 1 - i >= 0) a[a.length - 1 - i] else 0
            val bb = if (b.length - 1 - i >= 0) b[b.length - 1 - i] else 0
            var sum = extra
            if (aa == '1') sum += 1
            if (bb == '1') sum += 1
            extra = sum / 2
            res.add(sum % 2)
        }
        if (extra > 0) {
            res.add(extra)
        }

        return res.reversed().joinToString("")
    }

    @Test
    fun test() {
        val res = this.addBinary("1010", "1011")
        println("res = ${res}")

    }
}