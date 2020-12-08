package com.yuankui.leetcode.c100.q60

import org.junit.jupiter.api.Test

class Solution {
    fun getPermutation(n: Int, k: Int): String {
        var blockSize = 1
        for (i in 1 until n) {
            blockSize *= i
        }
        var acc = 0
        val left = MutableList(n) { (it + 1).toString() }
        val res = mutableListOf<String>()
        
        val kk = k -1
        for (i in (n-1) downTo 1) {
            
            val index = (kk - acc) / blockSize
            acc += blockSize * index
            val choose = left[index]
            left.removeAt(index)
            res.add(choose)
            blockSize /= i
        }
        res.addAll(left)
        return res.joinToString("")
    }

    @Test
    fun test() {
        for (i in 1..24) {
            val res = this.getPermutation(4, i)
            println("${i} => ${res}")
        }
        
    }
}