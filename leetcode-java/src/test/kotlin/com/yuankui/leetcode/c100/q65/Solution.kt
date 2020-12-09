package com.yuankui.leetcode.c100.q65

import org.junit.jupiter.api.Test

/**
 * DFA, NFA学习: https://blog.csdn.net/axwolfer/article/details/104128274
 */
class Solution {
    fun isNumber(s: String): Boolean {
        val digits = "0123456789"
        val space = " "
        val ops = "-+"
        val point = "."
        val exp = "Ee"

        val trans = mapOf(
                "S1" to mapOf(
                        digits to "S4",
                        space to "S2",
                        point to "S51"
                ),
                "S2" to mapOf(
                        digits to "S4",
                        space to "S2",
                        ops to "S3",
                        point to "S51"
                ),
                "S3" to mapOf(
                        digits to "S4"
                ),
                "S4" to mapOf(
                        point to "S5",
                        space to "S9",
                        exp to "S6",
                        digits to "S4"
                ),
                "S5" to mapOf(
                        digits to "S5",
                        exp to "S6",
                        space to "S9"
                ),
                "S51" to mapOf(
                        digits to "S5"
                ),
                "S6" to mapOf(
                        digits to "S8",
                        ops to "S7"
                ),
                "S7" to mapOf(
                        digits to "S8"
                ),
                "S8" to mapOf(
                        digits to "S8",
                        space to "S9"
                ),
                "S9" to mapOf(
                        space to "S9"
                )
        )

        val endState = setOf("S4", "S5", "S8", "S9")

        var currrent = "S1"
        outer@ for (c in s) {
            for (entry in trans[currrent]!!.entries) {
                val charSet = entry.key
                val nextState = entry.value

                // 能够根据当前输入，找到下一个状态
                if (c in charSet) {
                    currrent = nextState
                    continue@outer
                }
            }
            // 不能找到下一个状态
            return false
        }

        return currrent in endState
    }

    @Test
    fun test() {
        val inputs = mapOf(
                "0" to true,
                " 0.1 " to true,
                "abc" to false,
                "1 a" to false,
                "2e10" to true,
                " -90e3" to true,
                " 1e" to false,
                "e3" to false,
                " 6e-1" to true,
                " 99e2.5" to false,
                "53.5e93" to true,
                " --6 " to false,
                "-+3" to false,
                "95a54e53" to false,
                ".1" to true,
        )
        for (input in inputs) {
            val output = this.isNumber(input.key)
            assert(output == input.value)
            println("${input} => ${output}")
        }
    }

    @Test
    fun test2() {
        val inputs = listOf(
                ".1",
        )
        for (input in inputs) {
            val output = this.isNumber(input)
            println("${input} => ${output}")
        }
    }

    /**
     * 正则表达式: ^\s*(-|\+)?\d+(\.\d+)?((E|e)(-?)\d+)?
     *
     * DFA链接:
     *  - https://dreampuf.github.io/GraphvizOnline/#digraph%20G%20%7B%0A%20%20%20%20s1%20-%3E%20s4%20%5Blabel%20%3D%20%22digit%22%5D%0A%20%20%20%20s1%20-%3E%20s2%20%5Blabel%20%3D%20%22space%22%5D%0A%20%20%20%20s2%20-%3E%20s2%20%5Blabel%20%3D%20%22space%22%5D%0A%20%20%20%20s2%20-%3E%20s4%20%5Blabel%20%3D%20%22digit%22%5D%0A%20%20%20%20%0A%20%20%20%20s2%20-%3E%20s3%20%5Blabel%20%3D%20%22-%2F%2B%22%5D%0A%20%20%20%20s3%20-%3E%20s4%20%5Blabel%20%3D%20%22digit%22%5D%0A%20%20%20%20%0A%20%20%20%20s4%20%5Bshape%20%3D%20doublecircle%5D%0A%20%20%20%20%0A%20%20%20%20s4%20-%3E%20s5%20%5Blabel%20%3D%20%22%5C%22.%5C%22%22%5D%0A%20%20%20%20s5%20-%3E%20s5%20%5Blabel%20%3D%20%22digit%22%5D%0A%20%20%20%20%0A%0A%20%20%20%20%0A%20%20%20%20s5%20-%3E%20s6%20%5Blabel%20%3D%20%22E%2Fe%22%5D%0A%20%20%20%20%0A%20%20%20%20s6%20-%3E%20s7%20%5Blabel%20%3D%20%22-%2F%2B%22%5D%0A%20%20%20%20%0A%20%20%20%20s6%20-%3E%20s8%20%5Blabel%20%3D%20%22digit%22%5D%0A%0A%20%20%20%20s7%20-%3E%20s8%20%5Blabel%20%3D%20%22digit%22%5D%0A%20%20%20%20s8%20-%3E%20s8%20%5Blabel%20%3D%20%22digit%22%5D%0A%20%20%20%20%0A%20%20%20%20s4%20-%3E%20s9%20%5Blabel%20%3D%20%22space%22%5D%0A%20%20%20%20s5%20-%3E%20s9%20%5Blabel%20%3D%20%22space%22%5D%0A%20%20%20%20s8%20-%3E%20s9%20%5Blabel%20%3D%20%22space%22%5D%0A%20%20%20%20s9%20-%3E%20s9%20%5Blabel%20%3D%20%22space%22%5D%0A%20%20%20%20%0A%20%20%20%20s5%20%5Bshape%3Ddoublecircle%5D%0A%0A%20%20%20%20s8%20%5Bshape%3Ddoublecircle%5D%0A%20%20%20%20s9%20%5Bshape%3Ddoublecircle%5D%0A%7D
     */
}