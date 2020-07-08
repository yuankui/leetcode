package com.yuankui.leetcode

import org.junit.jupiter.api.Test

class Q0006ZigZag {
    fun convert(s: String, numRows: Int): String {
        if (numRows == 1) {
            return s
        }
        val cube = initCharCube(numRows, s.length)

        s.forEachIndexed { i: Int, c: Char ->
            val w = numRows + numRows - 2

            val base = i / w
            val remain = i % w



            if (remain < numRows) {
                cube[remain][base * (numRows - 1)] = c
            } else {
                cube[(numRows-1)- (remain - numRows + 1)][base * (numRows - 1) + numRows - (w - remain) - 1] = c
            }
        }

        val sb = StringBuffer()

        for (row in 0 until numRows) {
            for (column in 0 until s.length) {
                val c = cube[row][column]
                if (c != null) {
                    sb.append(c)
                }
            }
        }


        return sb.toString()
    }

    fun initCharCube(m: Int, n: Int): Array<Array<Char?>> {
        return Array<Array<Char?>>(m, init = {
            Array(n, init = {
                null
            })
        })
    }

    @Test
    fun test1() {
        val a = Q0006ZigZag().convert("PAYPALISHIRING", 3)

        println("a = $a")
    }

    @Test
    fun test2() {
        val a = Q0006ZigZag().convert("PAYPALISHIRING", 4)

        println("a = $a")
    }
}