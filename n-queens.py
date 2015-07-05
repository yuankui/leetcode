# coding=utf-8

class Solution:
    # @param {integer} n
    # @return {string[][]}
    def solveNQueens(self, n):
        return self.fullPermutation(n)

    def calcSolutionMap(self, n):
        '''优化formatSolution的,一行的字符不要每次即时生成,而改成提前生成好,需要的时候直接取'''
        self.solutionMap = {}
        for i in range(n):
            left, right = i, n - 1 - i
            self.solutionMap[i] = line = '.' * left + 'Q' + '.' * right

    def fullPermutation(self, n):
        self.used = {}
        self.plus = {}
        self.minus = {}
        lst = []
        solutions = []
        self.calcSolutionMap(n)

        self.recurse(lst, n, solutions)
        return solutions

    def formatSolution(self, lst):
        return map(lambda x:self.solutionMap[x], lst)

    def recurse(self, lst, n, solutions):
        if len(lst) == n:
            solution = self.formatSolution(lst)
            solutions.append(solution)
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
            self.recurse(lst, n, solutions)
            self.used[i] = False
            self.plus[x+y] = False
            self.minus[x-y] = False
            lst.pop()


import unittest
class SolutionTest(unittest.TestCase):
    def setUp(self):
        self.s = Solution()

    def testFormatSolution(self):
        lst = [0,1,4,3,2,5]
        self.s.calcSolutionMap(len(lst))
        res = self.s.formatSolution(lst)
        print "\n".join(res)

    def testSolveNQueens(self):
        solutions = self.s.solveNQueens(4)
        for solution in solutions:
            self.outputSolution(solution)
            print '-' * 22
        self.s.solveNQueens(10)

    def outputSolution(self, lst):
        print "\n".join(lst)