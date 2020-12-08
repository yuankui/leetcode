package com.yuankui.leetcode.c100.q56

class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        intervals.sortBy { it.first() }

        var index = 0
        while (true) {
            var (left, right) = intervals[index]
            var next = index + 1
            while (true) {
                val nextInterval = intervals[next]
            }

        }

        return arrayOf()
    }
}