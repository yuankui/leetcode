# coding=utf-8
class Solution:
    # @param {character[][]} board
    # @param {string} word
    # @return {boolean}
    def exist(self, board, word):
        if not self.preCheck(board, word):
            return False
        self.lenY, self.lenX = len(board), len(board[0])
        self.used = {}
        self.board = board
        self.found = False
        for y, line in enumerate(board):
            for x, char in enumerate(line):
                if char == word[0]:
                    self.used[(x,y)] = True
                    self.search(board, (x, y), 0, word)
                    self.used[(x,y)] = False
                    if self.found:
                        return True
        return False

    def preCheck(self, board, word):
        '''to see if there are enough char num in the board,if not, there's no need to search'''

        # char -> char's num in the board
        availableCharNumMap = {}

        # char -> char's num in the word
        neededCharNumMap = {}
        def fillMapWithLine(m, ones):
            for one in ones:
                if one in m:
                    m[one] += 1
                else:
                    m[one] = 1
        for line in board:
            fillMapWithLine(availableCharNumMap, line)
        fillMapWithLine(neededCharNumMap, word)

        for char, num in neededCharNumMap.items():
            ok = char in availableCharNumMap and availableCharNumMap.get(char) >= num
            if not ok:
                return False
        return True

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
        '''当前位于,已经搞定word中的第index个字母'''
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

        assert self.s.exist(board, "ABCCED") == True
        assert self.s.exist(board, "SEE") == True
        assert self.s.exist(board, "ABCB") == False
        assert self.s.exist(["aa"], "aaa") == False
        assert self.s.exist(["aaaa","aaaa","aaaa","aaaa","aaab"], "aaaaaaaaaaaaaaaaaaaa") == False
        print self.s.exist(["a"], "a")

    def testPreCheck(self):
        assert self.s.preCheck(["aaaa","aaaa","aaaa","aaaa","aaab"], "aaaaaaaaaaaaaaaaaaaa") == False