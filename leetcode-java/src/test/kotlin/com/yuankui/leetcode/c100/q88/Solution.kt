package com.yuankui.leetcode.c100.q88

import org.junit.jupiter.api.Test

class Solution {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var i = m - 1
        var j = m + n - 1
        for (idx in nums2.indices.reversed()) {
            val num = nums2[idx]
            while (i >= 0 && nums1[i] >= num) {
                nums1[j] = nums1[i]
                j -= 1
                i -= 1
            }
            nums1[j] = num
            j -= 1
        }
//        println("nums1.toList() = ${nums1.toList()}")
    }

    @Test
    fun test() {
//        this.merge(intArrayOf(1, 2, 3, 0, 0, 0), 3, intArrayOf(2, 5, 6), 3)
        this.merge(intArrayOf(0), 0, intArrayOf(1), 1)
    }
}