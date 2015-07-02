import unittest


class Solution:
    # @param {integer[]} nums
    # @param {integer} target
    # @return {integer}
    def searchInsert(self, nums, target):
        return self.searchBinary(nums, target, 0, len(nums) - 1)

    def searchBinary(self, nums, target, left, right):
        if right - left <= 1:
            if nums[left] >= target:
                return left
            elif nums[left] < target and target <= nums[right]:
                return left + 1
            else:
                return right + 1
        else:
            middle = int((left + right) / 2)
            middle_value = nums[middle]
            if target <= middle_value:
                return self.searchBinary(nums, target, left, middle)
            else:
                return self.searchBinary(nums, target, middle, right)


class SolutionTest(unittest.TestCase):
    def setUp(self):
        self.s = Solution()

    def testSearchInsert(self):
        nums, target, expect = [1, 3, 5, 6], 5, 2
        res = self.s.searchInsert(nums, target)

        self.assertEqual(res, expect)

        nums, target, expect = [1], 2, 1
        res = self.s.searchInsert(nums, target)

        self.assertEqual(res, expect)
