import unittest

class Solution:
    # @param {integer[]} nums
    # @return {integer}
    def singleNumber(self, nums):
        hash = {}
        for num in nums:
            if num in hash:
                hash[num] += 1
            else:
                hash[num] = 1


        for k, v in hash.items():
            if v != 2:
                return k


class SolutionTest(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

    def testGenerateList(self):
        pass
