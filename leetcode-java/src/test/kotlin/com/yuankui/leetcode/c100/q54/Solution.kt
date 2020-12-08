package com.yuankui.leetcode.c100.q54

import org.junit.jupiter.api.Test

class Solution {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val max = matrix.map { it.count() }.sum()
        val res = mutableListOf<Int>()
        val directions = listOf(
                Pair(0, 1),
                Pair(1, 0),
                Pair(0, -1),
                Pair(-1, 0)
        )

        var directionIndex = 0


        var current = Pair(0, 0)


        var minX = 0
        var minY = 0
        var maxX = matrix.first().size - 1
        var maxY = matrix.size - 1

        fun isValid(current: Pair<Int, Int>): Boolean {
            val (y, x) = current
            return x in minX..maxX && y in minY..maxY
        }

        for (i in 0 until max) {
            val direction = directions[directionIndex]
            val (y, x) = current

            println(matrix[y][x])
            res.add(matrix[y][x])

            // next
            if (isValid(current + direction)) {
                current += direction
            } else {
                directionIndex = (directionIndex + 1 + directions.size) % directions.size
                val d = directions[directionIndex]
                current += d
                when {
                    d.first > 0 -> {
                        minY += 1
                    }
                    d.first < 0 -> {
                        maxY -= 1
                    }
                    d.second < 0 -> {
                        maxX -= 1
                    }
                    d.second > 0 -> {
                        minX += 1
                    }
                }

            }
        }

        return res
    }

    operator fun Pair<Int, Int>.plus(o: Pair<Int, Int>): Pair<Int, Int> {
        val (a1, a2) = this
        val (b1, b2) = o
        return Pair(a1 + b1, b2 + a2)
    }

    @Test
    fun test() {
        val input = arrayOf(
                intArrayOf(1, 2, 3),
                intArrayOf(4, 5, 6),
                intArrayOf(7, 8, 9),
        )

        val res = this.spiralOrder(input)

        println("res = ${res}")
    }
}