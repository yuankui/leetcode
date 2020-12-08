package com.yuankui.leetcode.c100.q56

import org.junit.jupiter.api.Test

class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        intervals.sortBy { it.first() }

        val res = mutableListOf<IntArray>()

        var index = 0
        var (left, right) = intervals[index]
        var next = index + 1

        while (true) {
            if (next >= intervals.size) {
                res.add(intArrayOf(left, right))
                break
            }
            val (nLeft, nRight) = intervals[next]

            if (nLeft > right) {
                res.add(intArrayOf(left, right))
                left = nLeft
                right = nRight
            } else if (nRight <= right) {
                
            } else {
                right = nRight
            }

            next += 1
        }

        return res.toTypedArray()
    }

    @Test
    fun test() {
        val input = arrayOf(
                intArrayOf(1, 3),
                intArrayOf(2, 6),
                intArrayOf(8, 10),
                intArrayOf(15, 18),
        )
        
        val res = this.merge(input)
        for (re in res) {
            println("re.toList() = ${re.toList()}")
        }
    }
}