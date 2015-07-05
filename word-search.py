class Solution:
    # @param {character[][]} board
    # @param {string} word
    # @return {boolean}
    def exist(self, board, word):
        self.lenY, self.lenX = len(board), len(board[0])
        self.used = {}
        self.board = board
        self.found = False
        for y, line in enumerate(board):
            for x, char in enumerate(line):
                self.search(board, (x, y), -1, word)
                if self.found:
                    return True
        return False


    directions = [(0, 1), (0, -1), (1, 0), (-1, 0)]

    def validPos(self, pos, char):
        x, y = pos
        if not self.found \
                and 0 <= x and x < self.lenX \
                and 0 <= y and y < self.lenY \
                and not self.used.get(pos) is True \
                and char == self.board[y][x]:
            return True
        else:
            return False

    def search(self, board, pos, index, word):
        if index == len(word) - 1:
            self.found = True
            return True
        for direction in Solution.directions:
            newX, newY = (pos[0] + direction[0], pos[1] + direction[1])
            newPos = (newX, newY)
            char = word[index + 1]
            if self.validPos(newPos, char):
                self.used[newPos] = True
                self.search(board, newPos, index + 1, word)
                self.used[newPos] = False


import unittest


class SolutionTest(unittest.TestCase):
    def setUp(self):
        self.s = Solution()

    def testExist(self):
        board = ["ABCE",
                 "SFCS",
                 "ADEE"]

        print self.s.exist(board, "ABCCED")
        print self.s.exist(board, "SEE")
        print self.s.exist(board, "ABCB")


        print self.s.exist(["aa"], "aaa")
        print self.s.exist(["aaaa","aaaa","aaaa","aaaa","aaab"], "aaaaaaaaaaaaaaaaaaaa")

