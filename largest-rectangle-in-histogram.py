import unittest




class Solution:
    # @param {integer[]} height
    # @return {integer}
    def largestRectangleArea(self, heights):
        n = len(heights)

        maxArea = 0
        for middle, height in enumerate(heights):
            left = middle
            right = middle
            while left - 1 >= 0 and heights[left - 1] >= height: left -= 1
            while right + 1 < n and heights[right + 1] >= height: right += 1
            thisArea = height * (right - left + 1)
            maxArea = max(maxArea, thisArea)

        return maxArea


class SolutionTest(unittest.TestCase):
    def testLargest(self):
        s = Solution()
        expect, arr = 10, [2, 1, 5, 6, 2, 3]
        actual = s.largestRectangleArea(arr)
        self.assertEqual(actual, expect)

