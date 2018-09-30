class Solution(object):
    def fourSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[List[int]]
        """

        # 1. sort
        nums = sorted(nums)
        delta = - nums[0]

        # { sum -> (lowIndex , higherIndex)}
        two_sum_lower = {}
        for lower in range(0, len(nums)):
            for higher in range(lower + 1, len(nums)):
                sum = nums[lower] + nums[higher]
                if two_sum_lower.get(sum) is not None:
                    two_sum_lower[sum].add((lower, higher))
                else:
                    two_sum_lower[sum] = {(lower, higher)}

        result = []
        for lower in range(0, len(nums)):
            for higher in range(lower + 1, len(nums)):
                sum = nums[lower] + nums[higher]
                tuples = two_sum_lower.get(target - sum)
                tuples = tuples if tuples is not None else []
                for (l, h) in tuples:
                    if l > higher:
                        result += [[nums[lower], nums[higher], nums[l], nums[h]]]

        return result


if __name__ == '__main__':
    ret = Solution().fourSum([1, 0, -1, 0, -2, 2], 0)
    print(ret)
