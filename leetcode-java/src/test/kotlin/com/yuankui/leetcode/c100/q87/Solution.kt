package com.yuankui.leetcode.c100.q87

import org.junit.jupiter.api.Test

class Solution {
    fun isScramble(s1: String, s2: String): Boolean {
        if (s1 == s2) {
            return true
        }

        if (s1.length <= 1) {
            return false
        }

        val s11 = mutableMapOf<Char, Int>()
        val s12 = mutableMapOf<Char, Int>()
        val s21 = mutableMapOf<Char, Int>()
        val s22 = mutableMapOf<Char, Int>()
        for (c in s1) {
            s12.addCount(c)
        }
        for (c in s2) {
            s21.addCount(c)
        }

        for (i in 1..(s1.length - 1)) {
            val c1 = s1[i - 1]
            val c2 = s2[s2.length - i]

            s11.addCount(c1)
            s12.delCount(c1)
            s22.addCount(c2)
            s21.delCount(c2)

            if (s11.equals(s22) && s12.equals(s21)) {
                return isScramble(s1.substring(0, i), s2.substring(s2.length - i))
                        && isScramble(s1.substring(i), s2.substring(0, s2.length - i))
            }
        }

        return false
    }

    fun MutableMap<Char, Int>.addCount(c: Char) {
        if (c in this) {
            this[c] = this[c]!! + 1
        } else {
            this[c] = 1
        }
    }

    fun MutableMap<Char, Int>.delCount(c: Char) {
        if (!this.containsKey(c)) return
        if (this[c] == 1) {
            this.remove(c)
        } else {
            this[c] = this[c]!! - 1
        }
    }

    fun MutableMap<Char, Int>.equals(other: MutableMap<Char, Int>): Boolean {
        if (this.size != other.size) {
            return false
        }

        return this.all { kv ->
            other[kv.key] == kv.value
        }
    }

    @Test
    fun test() {
        val res = this.isScramble("great", "rgeat")
        println("res = ${res}")
    }
}