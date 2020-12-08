package com.yuankui.leetcode.c50.q49

import org.junit.jupiter.api.Test

class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        return strs.groupBy { 
            it.asSequence().sorted().joinToString("")
        }
                .values.toList()
    }
    
    @Test
    fun test() {
        val res = this.groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat"))

        println("res = ${res}")
        
    }
}