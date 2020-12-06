package com.yuankui.leetcode.q41

import org.junit.jupiter.api.Test

class UseInplace {
    fun firstMissingPositive(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 1
        }

        fun getValue(i: Int): Int {
            return nums[i - 1]
        }

        fun setValue(i: Int, value: Int) {
            nums[i - 1] = value
        }

        for (i in (1..nums.size)) {
            var index = i
            var value = getValue(index)
            if (value == index) continue
            if (value <= 0 || value > nums.size){
                setValue(i, -1)
                continue
            }

            setValue(index, -1)
            
            while (true) {
                if (value <= 0) break
                if (value > nums.size) break
                val v = getValue(value)
                setValue(value, value)
                index = value
                value = v
                
                if (value == index) {
                    break
                }
            }
        }

        println("nums = ${nums.toList()}")
        val foundIndex = nums.indices
                .firstOrNull { it < 0 || it + 1 != nums[it] }
        if (foundIndex == null) {
            return nums.size + 1
        } else {
            return foundIndex + 1
        }
    }

    @Test
    fun test() {
//        val res = this.firstMissingPositive(intArrayOf(1, 2, 0))
//        val res = this.firstMissingPositive(intArrayOf(3, 4, -1, 1))
//        val res = this.firstMissingPositive(intArrayOf(7, 8, 9, 11, 12))
        val res = this.firstMissingPositive(intArrayOf(1))
        println("res = ${res}")

    }
}