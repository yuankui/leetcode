package com.yuankui.leetcode.q37

import org.junit.jupiter.api.Test

class Solution {
    fun solveSudoku(board: Array<CharArray>): Unit {
        val cellState = board.indices
                .map { mutableSetOf<Char>() }
                .toTypedArray()

        val rowState = board.indices
                .map { mutableSetOf<Char>() }
                .toTypedArray()

        val columnState = board.indices
                .map { mutableSetOf<Char>() }
                .toTypedArray()

        fun posToRow(x: Int, y: Int): Int {
            return y
        }
        fun posToColumn(x: Int, y: Int): Int {
            return x
        }
        fun posToCell(x: Int, y: Int): Int {
            return y / 3 * 3 + x / 3
        }


        // 初始化容器
        for (i in board.indices) {
            for (j in board.indices) {
                val c = board[i][j]

                val rowIndex = posToRow(j, i)
                rowState.get(rowIndex) += c

                val columnIndex = posToColumn(j, i)
                columnState.get(columnIndex) += c

                val cellIndex = posToCell(j, i)
                cellState.get(cellIndex) += c
            }
        }


        // 递归深度优先
        fun search(i: Int, j: Int): Boolean {

            if (i == board.size) {
                return true
            }
            val c = board[i][j]
            if (c != '.') {
                // 换行
                if (j == board.size - 1) {
                    return search(i + 1, 0)
                } else {
                    return search(i, j + 1)
                }
            }

            val cell = cellState[posToCell(j, i)]
            val column = columnState[posToColumn(j, i)]
            val row = rowState[posToRow(j, i)]

            // 填入数字
            for (a in '1'..'9') {
                // 判断是否满足数独
                if (cell.contains(a)) continue
                if (column.contains(a)) continue
                if (row.contains(a)) continue

                // 满足
                cell.add(a)
                column.add(a)
                row.add(a)
                board[i][j] = a

                // 继续搜索
                if (j == board.size - 1) {
                    if (search(i + 1, 0)) {
                        return true
                    }
                } else {
                    if (search(i, j + 1)) {
                        return true
                    }
                }

                // 还原
                cell.remove(a)
                column.remove(a)
                row.remove(a)
                board[i][j] = '.'
            }
            return false
        }

        val res = search(0, 0)
        println("res = ${res}")
    }

    @Test
    fun test() {
        val board = arrayOf(
                "53..7....".toCharArray(),
                "6..195...".toCharArray(),
                ".98....6.".toCharArray(),
                "8...6...3".toCharArray(),
                "4..8.3..1".toCharArray(),
                "7...2...6".toCharArray(),
                ".6....28.".toCharArray(),
                "...419..5".toCharArray(),
                "....8..79".toCharArray(),
        )

        val res = this.solveSudoku(board)

        printBoard(board)
    }

    @Test
    fun test2() {
        val board = arrayOf(
                "..9748...".toCharArray(),
                "7........".toCharArray(),
                ".2.1.9...".toCharArray(),
                "..7...24.".toCharArray(),
                ".64.1.59.".toCharArray(),
                ".98...3..".toCharArray(),
                "...8.3.2.".toCharArray(),
                "........6".toCharArray(),
                "...2759..".toCharArray(),
        )

        val res = this.solveSudoku(board)

        printBoard(board)
    }

    fun printBoard(board: Array<CharArray>) {
        println()
        board.map { it.toList().joinToString("") }
                .forEach { println(it) }
    }
}