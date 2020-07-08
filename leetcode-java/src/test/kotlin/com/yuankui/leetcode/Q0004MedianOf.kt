package com.yuankui.leetcode

import org.junit.jupiter.api.Test

/**
 * 先粗，后细
 *
 * 先大踏步，后小踏步
 */
@Link("https://leetcode.com/problems/median-of-two-sorted-arrays/")
class Q0004MedianOf {

    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val total = nums1.size + nums2.size

        fun forward(min1: Int, min2: Int): Double {
            var i1 = min1
            var i2 = min2
            var queue = Pair(0, 0)

            0.until((nums1.size + nums2.size + 2) / 2).forEach {
                if (i1 <= nums1.size - 1 && (i2 > nums2.size - 1 || nums1[i1] <= nums2[i2])) {
                    val (_, max) = queue
                    queue = Pair(max, nums1[i1])
                    println("1 ->$i1, value = ${nums1[i1]}")
                    i1++
                } else {
                    val (_, max) = queue
                    queue = Pair(max, nums2[i2])
                    println("2 ->$i2, value = ${nums2[i2]}")
                    i2++
                }

                println("queue => $queue")
            }

            val (min, max) = queue
            return if (total % 2 == 0) {
                (min + max).toDouble() / 2
            } else {
                max.toDouble()
            }
        }


        return forward(0, 0)
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