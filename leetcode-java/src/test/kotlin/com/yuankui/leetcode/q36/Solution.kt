package com.yuankui.leetcode.q36

import org.junit.jupiter.api.Test

class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        // 列唯一
        for (i in board.indices) {
            val rowSet = mutableSetOf<Char>()
            val columnSet = mutableSetOf<Char>()
            val cellSet = mutableSetOf<Char>()

            for (j in board.indices) {
                // 行
                val rowChar = board[i][j]
                if (rowChar != '.' && rowChar in rowSet) {
                    return false
                }
                rowSet += rowChar

                // 列
                val columnChar = board[j][i]
                if(columnChar != '.' && columnChar in columnSet) {
                    return false
                }
                columnSet += columnChar

                // cell
                val outX = i % 3 * 3
                val outY = i / 3 * 3
                val inX = j % 3
                val inY = j / 3
                val char = board[outY + inY][outX + inX]
                if (char != '.' && char in cellSet) {
                    return false
                }
                cellSet += char
            }
        }

        return true
    }

    @Test
    fun test() {
        val board = arrayOf(
                charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
                charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
                charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
                charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
                charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
                charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
                charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
                charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
                charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
        )
        val res = this.isValidSudoku(board)
        println("res = ${res}")
    }
}