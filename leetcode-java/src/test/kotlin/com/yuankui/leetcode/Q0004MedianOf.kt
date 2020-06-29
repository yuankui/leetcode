package com.yuankui.leetcode

import org.junit.jupiter.api.Test


@Link("https://leetcode.com/problems/median-of-two-sorted-arrays/")
class Q0004MedianOf {

    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        return 1.0
    }

    @Test
    fun test() {
        val a = 1.rangeTo(7).map { it }.toIntArray()
        val b = 1.rangeTo(6).map { it * 2 }.toIntArray()

        println("a = ${a.toList()}")
        println("b = ${b.toList()}")
        val nums = (a + b).toList()
        println(nums.sorted())

        val ret = findMedianSortedArrays(a, b)
        println("ret = $ret")
        assert(ret == 5.0)
    }

    @Test
    fun test2() {
        val a = arrayOf(1, 3).toIntArray()
        val b = arrayOf(2).toIntArray()

        println("a = ${a.toList()}")
        println("b = ${b.toList()}")
        val nums = (a + b).toList()
        println(nums.sorted())

        val ret = findMedianSortedArrays(a, b)
        println(ret)
        assert(ret == 2.0)
    }

    @Test
    fun test3() {
        val a = arrayOf(1, 2).toIntArray()
        val b = arrayOf(3, 4).toIntArray()

        println("a = ${a.toList()}")
        println("b = ${b.toList()}")
        val nums = (a + b).toList()
        println(nums.sorted())

        val ret = findMedianSortedArrays(a, b)
        println(ret)
        assert(ret == 2.5)
    }

    @Test
    fun test4() {
        val a = arrayOf(2).toIntArray()
        val b = arrayOf<Int>().toIntArray()

        println("a = ${a.toList()}")
        println("b = ${b.toList()}")
        val nums = (a + b).toList()
        println(nums.sorted())

        val ret = findMedianSortedArrays(a, b)
        println(ret)
        assert(ret == 2.0)
    }
}