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

        val rowGetter = { i: Int, j: Int ->
            board[i][j]
        }

        val columnGetter = { i: Int, j: Int ->
            board[j][i]
        }

        val cellGetter = {i: Int, j: Int ->
            val outX = i % 3 * 3
            val outY = i / 3 * 3
            val inX = j % 3
            val inY = j / 3
            board[outY + inY][outX + inX]
        }

        // 初始化容器
        for (i in board.indices) {
            for (j in board.indices) {
                rowState.get(i) += rowGetter(i, j)
                columnState.get(i) += columnGetter(i, j)
                cellState.get(i) += cellGetter(i, j)
            }
        }


        // 递归深度优先
        fun search(i: Int, j: Int): Boolean {
            if (i == board.size - 1 && j == board.size - 1) {
                return true
            }
            val c = columnGetter(i, j)
            if (c != '.') {
                // 换行
                if (j == board.size - 1) {
                    return search(i + 1, 0)
                } else {
                    return search(i, j + 1)
                }
            }

            // 填入数字
            for (a in '1'..'9') {
                // 判断是否满足数独
                if (cellState[i].contains(a)) continue
                if (columnState[i].contains(a)) continue
                if (rowState[i].contains(a)) continue

                // 满足
                cellState[i].add(a)
                columnState[i].add(a)
                rowState[i].add(a)
                board[i][j] = a

                printBoard(board)
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
                cellState[i].remove(a)
                columnState[i].remove(a)
                rowState[i].remove(a)
                board[i][j] = '.'
            }
            return false
        }

        search(0, 0)
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

        this.solveSudoku(board)

        printBoard(board)
    }

    fun printBoard(board: Array<CharArray>) {
        println()
        board.map { it.toList().joinToString("") }
                .forEach { println(it) }
    }
}