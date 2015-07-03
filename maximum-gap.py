import unittest


class Solution:
    # @param {integer[]} nums
    # @return {integer}
    def maximumGap(self, nums):
        if len(nums) < 2:
            return 0
        sortedNums = sorted(nums)

        maxGap = 0
        last = sortedNums[0]

        for num in sortedNums[1:]:
            gap = num - last
            maxGap = max(gap, maxGap)
            last = num
        return maxGap


class SolutionTest(unittest.TestCase):
    def setUp(self):
        self.s = Solution()

    def testMaximumGap(self):
        nums, gap = [5, 8, 7, 2, 11, 9], 3
        actual = self.s.maximumGap(nums)
        self.assertEqual(gap, actual)

