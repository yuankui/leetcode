package com.yuankui.leetcode

import org.junit.jupiter.api.Test

/**
 * 思路：
 * 单边淘汰
 * 
 * 总数n+m个，先单边淘汰掉(n+m-2)/2个，然后剩余2个，如果相等，就返回任意一个，如果不相等，就返回他们的平均值
 * 
 * 如何进行单边淘汰：
 *  1. 尝试淘汰其中一个数组的一半，然后，取他最大值，以这个最大值为基准，淘汰掉所有比这个数小的另外一个数组的数，通过移动下标。
 */
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