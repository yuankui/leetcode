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
                    else h[j] = 0
                }


                // 上升
                if (h.getValue(j) >= h.getValue(deque.last())) {
                    deque.add(j)
                    continue
                }

                while (h.getValue(j) < h.getValue(deque.last())) {
                    var left = deque.removeLast()
                    val height = h.getValue(left)
                    while (h.getValue(left) == h.getValue(deque.last())) {
                        left = deque.removeLast()
                    }
                    left = deque.last()
                    
                    if (height * (j - left - 1) > max) {
                        max = height * (j - left -1)
                    }
                }
                deque.addLast(j)
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
        
//        val input = arrayOf(
//                "11".toCharArray(),
//        )
        
        
        val input = arrayOf(
                "001".toCharArray(),
                "111".toCharArray(),
        )
        val res = this.maximalRectangle(input)
        println("res = ${res}")
    }
}