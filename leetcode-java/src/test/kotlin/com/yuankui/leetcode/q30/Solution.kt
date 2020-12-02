package com.yuankui.leetcode.q30

import org.junit.jupiter.api.Test

class Solution {
    fun findSubstring(s: String, words: Array<String>): List<Int> {
        val wordsLength = words.map { it.length }.sum()
        val wordLength = words.first().length

        val wordCount: Map<String, Int> = words.groupBy { it }
                .mapValues { it.value.size }
        

        val res = mutableListOf<Int>()
        outer@ for (i in 0..(s.length - wordsLength)) {
            val wordMap = mutableMapOf<String, Int>()
            
            for (j in words.indices) {
                val word = s.substring(i + j * wordLength, i + (j + 1) * wordLength)
                val count = wordMap[word] ?: 0
                wordMap[word] = count +  1
            }
            for (key in wordCount.keys) {
                if (wordMap[key] != wordCount[key]) {
                    continue@outer
                }
            }
            
            res.add(i)
            
        }
        return res
    }
    
    @Test
    fun test() {
        val res = this.findSubstring("barfoothefoobarman", arrayOf("foo", "bar"))

        println("res = ${res}")

        val findSubstring = this.findSubstring("wordgoodgoodgoodbestword", arrayOf("word", "good", "best", "word"))

        println("findSubstring = ${findSubstring}")
    }
}