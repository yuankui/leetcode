class Solution:
    # @param {integer[]} nums
    # @param {integer} target
    # @return {integer[]}
    def twoSum(self, nums, target):
        exist_hash = {}
        for index, num in enumerate(nums):
            exist_hash[num] = index

        for index, left_num in enumerate(nums):
            right_num = target - left_num
            right_index = exist_hash.get(right_num)
            if right_index == None:
                continue

            if right_index > index:
                return [index + 1, right_index + 1]