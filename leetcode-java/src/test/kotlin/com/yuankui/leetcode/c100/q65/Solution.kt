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
                "s1" to mapOf(
                        space to "s2",
                        ops to "s3",
                        point to "s4",
                        digits to "s5"
                ),
                "s2" to mapOf(
                        ops to "s3",
                        point to "s4",
                        digits to "s5",
                        space to "s2"
                ),
                "s3" to mapOf(
                        point to "s4",
                        digits to "s5"
                ),
                "s4" to mapOf(
                        digits to "s41"
                ),
                "s41" to mapOf(
                        digits to "s41",
                        exp to "s8",
                        space to "s11"
                ),
                "s5" to mapOf(
                        point to "s6",
                        exp to "s8",
                        space to "s11",
                        digits to "s5"
                ),
                "s6" to mapOf(
                        digits to "s7",
                        exp to "s8",
                        space to "s11"
                ),
                "s7" to mapOf(
                        digits to "s7",
                        exp to "s8",
                        space to "s11"
                ),
                "s8" to mapOf(
                        ops to "s9",
                        digits to "s10"
                ),
                "s9" to mapOf(
                        digits to "s10"
                ),
                "s10" to mapOf(
                        digits to "s10",
                        space to "s11"
                ),
                "s11" to mapOf(
                        space to "s11"
                )
        )

        val endState = setOf("s41", "s5", "s6", "s7", "s10", "s11")

        var currrent = "s1"
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
                "  2.8" to true,
        )
        for (input in inputs) {
            val output = this.isNumber(input.key)
            println("input.key = ${input.key}")
            assert(output == input.value)
        }
    }

    @Test
    fun test2() {
        val input = "  2.8"
        val output = this.isNumber(input)
        println("${input} => ${output}")
    }

    /**
     * 正则表达式: \s*(-|\+)?((\d+(\.\d*)?)|\.\d+)((E|e)(-|\+)?\d+)?\s*
     *
     * DFA链接:
     *  - https://dreampuf.github.io/GraphvizOnline/#digraph%20G%20%7B%0A%20%20%20%20%0A%20%20%20%20s1%2C%20s2%20-%3E%20s2%20%5Blabel%20%3D%20%22%5C%5Cs%22%5D%0A%20%20%20%20s1%2C%20s2%20-%3E%20s3%20%5Blabel%20%3D%20%22-%7C%2B%22%5D%0A%20%20%20%20s1%2C%20s2%2C%20s3%20-%3E%20s4%20%5Blabel%20%3D%20%22%5C%5C.%22%5D%0A%20%20%20%20s1%2C%20s2%2C%20s3%20-%3E%20s5%20%5Blabel%20%3D%20%22%5C%5Cd%22%5D%0A%20%20%20%20%0A%20%20%20%20s4%2C%20s41%20-%3E%20s41%20%5Blabel%20%3D%20%22%5Cd%22%5D%0A%20%20%20%20%0A%20%20%20%20%0A%20%20%20%20s5%20-%3E%20s6%20%5Blabel%20%3D%20%22%5C%5C.%22%5D%0A%20%20%20%20s6%2C%20s7%20-%3E%20s7%20%5Blabel%20%3D%20%22%5C%5Cd%22%5D%0A%20%20%20%20%0A%20%20%20%20s41%2C%20s5%2C%20s6%2C%20s7%20-%3E%20s8%20%5Blabel%20%3D%20%22E%7Ce%22%5D%0A%20%20%20%20s8%20-%3E%20s9%20%5Blabel%20%3D%20%22-%7C%2B%22%5D%0A%20%20%20%20%0A%20%20%20%20s8%2C%20s9%2C%20s10%20-%3E%20s10%20%5Blabel%20%3D%20%22%5C%5Cd%22%5D%0A%20%20%20%20%0A%20%20%20%20s10%2C%20s11%20-%3E%20s11%20%5Blabel%20%3D%20%22%5C%5Cs%22%5D%0A%20%20%20%20%0A%20%20%20%20s4%2C%20s5%2C%20s6%2C%20s7%2C%20s10%2C%20s11%20%5Bshape%3Ddoublecircle%5D%0A%20%20%0A%7D
     */
}