package com.yuankui.leetcode.c100.q68

import org.junit.jupiter.api.Test

class Solution {
    fun fullJustify(words: Array<String>, maxWidth: Int): List<String> {
        var p = 0
        val res = mutableListOf<String>()

        outer@ while (true) {
            var wordsLen = 0
            val list = mutableListOf<String>()
            if (p >= words.size) {
                break
            }
            while (true) {
                if (p >= words.size) {
                    break
                }
                val word = words[p]
                val len = word.length

                if (wordsLen + len + list.size <= maxWidth) {
                    list.add(word)
                    wordsLen += len
                    p += 1
                } else {
                    break
                }
            }

            val overflow = maxWidth - (wordsLen + list.size - 1)

            var mod = if (list.size != 1) overflow % (list.size - 1) else overflow
            val every = if (list.size != 1) overflow / (list.size - 1) else 0

            val sb = StringBuilder()

            if (p == words.size) {
                // 如果是最后一行单词，特殊处理
                val w = list.joinToString(" ")
                val spaceSize = maxWidth - w.length
                sb.append(w)
                for (i in 0 until spaceSize) {
                    sb.append(' ')
                }
                res.add(sb.toString())
                break
            }
            for (index in list.indices) {
                val word = list[index]

                // 插入单词
                sb.append(word)

                if (index == list.size - 1) {
                    // 最后一个右边不插入空格
                    break
                }

                // 多余的空格插入到最开始
                if (mod > 0) {
                    sb.append(' ')
                    mod -= 1
                }

                // 每个单词直接固定空格
                for (i in 0 .. every) {
                    sb.append(' ')
                }
            }
            for (i in 0 until mod) {
                sb.append(' ')
            }

            res.add(sb.toString())
        }

        return res
    }

    @Test
    fun test() {
        val res = this.fullJustify(arrayOf("This", "is", "an", "example", "of", "text", "justification."), 16)
//        val res = this.fullJustify(arrayOf("What","must","be","acknowledgment","shall","be"), 16)
//        val res = this.fullJustify(arrayOf("Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"), 20)
        for (re in res) {
            println(re)
        }
    }
}