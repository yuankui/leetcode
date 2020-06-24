package com.yuankui.leetcode

import org.junit.jupiter.api.Test
import kotlin.math.min

fun Int.repeat(str: String): String {
    return 0.until(this).map { str }.joinToString("")
}

class Q0004MedianOf {
    
    fun findIndex(nums: IntArray, left: Int, right: Int, max: Int): Int {
        var midIndex = right
        while (true) {
            if (nums[midIndex] <= max) {
                return midIndex
            }
            if (left + 1 == midIndex) {
                return left
            }
            midIndex = (left + midIndex) / 2
        }
    }

    fun printArrayIndex(nums: IntArray, index: Int, name: String = "") {
        val str = nums.map { String.format("%3d", it) }.joinToString(", ", "[", "]")
        println("$name: " + str)
        println(name.length.repeat(" ") + "     " + 0.until(index).map { "     " }.joinToString("") + "*")
    }
    
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        
        fun forward(min1: Int, min2: Int, max1: Int, max2: Int): Double {
            var i1 = min1
            var i2 = min2

            0.rangeTo(10).forEach {
                val min = min(nums1[(i1 + max1) / 2], nums2[(i2 + max2) / 2])

                // move 1 index
                i1 = findIndex(nums1, i1, (i1 + nums1.size) / 2, min)
                

                
                i2 = findIndex(nums2, i2, (i2 + nums2.size) / 2, min)
            }
            return 1.0
        }


        return forward(0, 0, nums1.size - 1, nums2.size - 1)
        
    }


    @Test
    fun findIndexTest() {
        val array = arrayOf(1, 2, 3, 4, 5, 6).map { it * 2 }.toIntArray()
        val left = 1
        val right = 5
        val findIndex = findIndex(array, left, right, 7)
        println("findIndex = ${findIndex}")
        printArrayIndex(array, left)
        printArrayIndex(array, right)
        printArrayIndex(array, findIndex)
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