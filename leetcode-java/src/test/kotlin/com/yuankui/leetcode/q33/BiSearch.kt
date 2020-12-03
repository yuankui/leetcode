package com.yuankui.leetcode.q33

import org.junit.jupiter.api.Test

class BiSearch {
    fun search(nums: IntArray, target: Int): Int {
        return search(nums, 0, nums.size, target)
    }

    fun biSearch(nums: IntArray, start: Int, end: Int, target: Int): Int {
        val midIndex = (start + end) / 2
        val mid = nums[midIndex]

        if (midIndex == start) {
            return if (mid == target) {
                midIndex
            } else {
                -1
            }
        }

        if (mid == target) {
            return midIndex
        } else if (mid < target) {
            return biSearch(nums, midIndex, end, target)
        } else {
            return biSearch(nums, start, midIndex, target)
        }
    }

    fun search(nums: IntArray, start: Int, end: Int, target: Int): Int {
        val midIndex = (start + end) / 2
        val mid = nums[midIndex]
        val first = nums[start]

        if (midIndex == start) {
            return if (target == mid) midIndex else -1
        }
        
        if (mid == target) {
            return midIndex
        }
        if (mid > first) {
            val index = biSearch(nums, start, midIndex, target)
            if (index >= 0) {
                return index
            }
            return search(nums, midIndex, end, target)
        } else if (mid < first) {
            val index = biSearch(nums, midIndex, end, target)
            if (index >= 0) {
                return index
            }
            return search(nums, start, midIndex, target);
        } else {
            return midIndex
        }
    }

    @Test
    fun test() {
        val arr = intArrayOf(4, 5, 6, 7, 0, 1, 2)
        for (i in arr) {
            val index = this.search(arr, i)

            println("${i} => ${index}")
        }
        
        val r1 = this.search(arr, 8)
        val r2 = this.search(arr, 3)

        println("r1 = ${r1}")
        println("r2 = ${r2}")
    }
}