# coding=utf-8

class Solution:
    # @param {integer} n
    # @return {string[][]}
    def totalNQueens(self, n):
        return self.fullPermutation(n)

    def fullPermutation(self, n):
        self.used = {}
        self.plus = {}
        self.minus = {}
        lst = []
        self.solutions = 0

        self.recurse(lst, n)
        return self.solutions

    def recurse(self, lst, n):
        if len(lst) == n:
            self.solutions += 1
            return

        for i in xrange(n):
            x,y = i, len(lst) + 1
            if self.used.get(i) is True \
                or self.minus.get(x-y) is True \
                or self.plus.get(x+y) is True:
                continue

            self.used[i] = True
            self.plus[x+y] = True
            self.minus[x-y] = True
            lst.append(i)
            self.recurse(lst, n)
            self.used[i] = False
            self.plus[x+y] = False
            self.minus[x-y] = False
            lst.pop()


import unittest
class SolutionTest(unittest.TestCase):
    def setUp(self):
        self.s = Solution()

    def testSolveNQueens(self):
        print self.s.totalNQueens(4)
        print self.s.totalNQueens(11)

