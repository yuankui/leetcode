package com.yuankui.leetcode.c100.q85

import org.junit.jupiter.api.Test

class Stack {
    fun maximalRectangle(matrix: Array<CharArray>): Int {
        if (matrix.size == 0) return 0
        val h = IntArray(matrix.first().size) { 0 }

        var max = 0
        for (i in matrix.indices) {
            val deque = ArrayDeque<Int>()
            deque.add(-1)

            for (j in 0..(matrix.first().size)) {
                if (j < matrix.first().size) {
                    if (matrix[i][j] == '1') h[j] += 1
                }


                // 上升
                if (h.getValue(j) >= h.getValue(deque.last())) {
                    deque.add(j)
                    continue
                }

                var v = h.getValue(j)
                while (v < h.getValue(deque.last())) {
                    val last = deque.removeLast()
                    if (h[last] * (j - last) > max) {
                        max = h.getValue(last) * (j - last)
                    }
                    v = h.getValue(deque.last())
                }

            }
        }

        return max;
    }

    fun IntArray.getValue(i: Int): Int {
        if (i < 0) return 0
        if (i >= this.size) return 0

        return this[i]
    }

    @Test
    fun test() {
//        val input = arrayOf(
//                "10100".toCharArray(),
//                "10111".toCharArray(),
//                "11111".toCharArray(),
//                "10010".toCharArray(),
//        )
        val input = arrayOf(
                "1".toCharArray(),
        )
        val res = this.maximalRectangle(input)
        println("res = ${res}")
    }
}