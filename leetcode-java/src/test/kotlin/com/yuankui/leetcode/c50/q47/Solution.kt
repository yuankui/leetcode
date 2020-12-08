package com.yuankui.leetcode.c50.q47

import org.junit.jupiter.api.Test

class Solution {
    fun permuteUnique(nums: IntArray): List<List<Int>> {
        val emptyValue = nums.max()!! + 1

        nums.sort()

        val res = mutableListOf<List<Int>>()

        val valueCount = nums.groupBy { it }
                .mapValues { it.value.size }
                .toList()
                .sortedBy { it.first }

        // 将value放在list中的正确位置
        fun fill(list: IntArray, valueIndex: Int, minIndex: Int, remainCount: Int) {
            val (value, count) = valueCount[valueIndex]!!

            for (i in (minIndex until nums.size)) {
                // 找一个空位
                if (list[i] != emptyValue) continue

                // 放到第i个位置上
                try {
                    list[i] = value
                    if (remainCount == 1) {
                        if (valueIndex == valueCount.size - 1) {
                            res.add(list.toList())
                            return
                        }
                        // 改数字已经用完，改用下一个了
                        fill(list, valueIndex + 1, 0, valueCount[valueIndex + 1].second)
                    } else {
                        fill(list, valueIndex, i + 1, remainCount - 1)
                    }
                } finally {
                    list[i] = emptyValue
                }

            }
        }

        val intArray = IntArray(nums.size) { emptyValue }

        val firstValue = valueCount.first()
        fill(intArray, 0, 0, firstValue.second)

        return res
    }


    @Test
    fun test() {
//        val res = this.permuteUnique(intArrayOf(1, 1, 2))
        val res = this.permuteUnique(intArrayOf(1, 2, 3))
        println("res = ${res}")

    }
}