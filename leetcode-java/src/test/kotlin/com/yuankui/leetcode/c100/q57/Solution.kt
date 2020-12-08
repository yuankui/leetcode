package com.yuankui.leetcode.c100.q57

import org.junit.jupiter.api.Test

class Solution {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        intervals.sortBy { it.first() }

        val res = mutableListOf<IntArray>()

        var (left, right) = Pair(Int.MIN_VALUE, Int.MIN_VALUE)
        var next = 0
        var used = false

        while (true) {
            if (next >= intervals.size && used) {
                res.add(intArrayOf(left, right))
                break
            }

            var nextInterval: IntArray
            // 获取下一个区间
            if (next >= intervals.size || (!used && newInterval[0] < intervals[next][0])) {
                // 如果待插入区间优先，就先处理待插入区间
                used = true
                nextInterval = newInterval
            } else {
                nextInterval = intervals[next]
                next += 1
            }

            val (nLeft, nRight) = nextInterval

            if (nLeft > right) {
                if (left != Int.MIN_VALUE && right != Int.MIN_VALUE) {
                    res.add(intArrayOf(left, right))
                }
                left = nLeft
                right = nRight
            } else if (nRight <= right) {

            } else {
                right = nRight
            }
        }

        return res.toTypedArray()
    }

    @Test
    fun test() {
        val input = arrayOf(
                intArrayOf(1, 3),
                intArrayOf(6, 9),
        )
        val output = this.insert(input, intArrayOf(0, 0))
        
//        val input = arrayOf<IntArray>()
//        val output = this.insert(input, intArrayOf(2, 5))
        for (ints in output) {
            println("ints.toList() = ${ints.toList()}")
        }
        
    }
}