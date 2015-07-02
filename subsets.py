from collections import deque
import unittest

class Solution:
    # @param {integer[]} nums
    # @return {integer[][]}
    def subsets(self, nums):
        self.nums = nums
        res = self.generateList(0, deque(),[])
        return res

    def setNums(self, nums):
        self.nums = nums

    def generateList(self, index, queue, res):
        if index >= len(self.nums):
            res.append(sorted(queue))
            return

        self.generateList(index + 1, queue, res)

        queue.append(self.nums[index])
        self.generateList(index + 1, queue, res)

        queue.pop()
        return res

class SolutionTest(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

    def testGenerateList(self):
        self.solution.setNums([4,1,0])

        res = self.solution.generateList(0, deque(), [])

        print list(res)