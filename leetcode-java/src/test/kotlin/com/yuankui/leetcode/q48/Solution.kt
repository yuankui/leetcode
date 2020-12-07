package com.yuankui.leetcode.q48

import org.junit.jupiter.api.Test

class Solution {
    fun rotate(matrix: Array<IntArray>) {
        val size = matrix.size

        val mid = size / 2 - 1
        for (i in (0 until (size - 1))) {
            var maxJ = i + 1
            if (i > mid)  {
                maxJ -= (i - mid) * 2
                if (size % 2 == 1) maxJ += 1
            }

            println(maxJ)
            
            for (j in 0 until (maxJ)) {
                // 元素位置
                val x1 = i
                val y1 = j

                val y2 = x1
                val x2 = (size - 1) - y1

                val x3 = (size - 1) - x1
                val y3 = (size - 1) - y1

                val x4 = (size - 1) - x2
                val y4 = (size - 1) - y2

                var v = matrix[y1][x1]
                matrix[y1][x1] = matrix[y4][x4]
                matrix[y4][x4] = matrix[y3][x3]
                matrix[y3][x3] = matrix[y2][x2]
                matrix[y2][x2] = v
            }
        }
    }

    @Test
    fun test() {
//        val array = arrayOf(
//                intArrayOf(1,2,3),
//                intArrayOf(4,5,6),
//                intArrayOf(7,8,9),
//        )
//
        val array = arrayOf(
                intArrayOf(5, 1, 9, 11),
                intArrayOf(2, 4, 8, 10),
                intArrayOf(13, 3, 6, 7),
                intArrayOf(15, 14, 12, 16),
        )

        this.rotate(array)

        printArray(array)
    }

    @Test
    fun test2() {
        val arr = arrayOf(
                intArrayOf(15, 13, 2, 5),
                intArrayOf(14, 3, 4, 1),
                intArrayOf(12, 6, 8, 9),
                intArrayOf(16, 7, 10, 11),
        )

        printArray(arr)
    }

    fun printArray(arr: Array<IntArray>) {
        for (ints in arr) {
            for (int in ints) {
                print(int)
                print(',')
            }
            println()
        }
    }
}