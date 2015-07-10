class Solution:
    # @param {integer[]} candidates
    # @param {integer} target
    # @return {integer[][]}
    def combinationSum2(self, candidates, target):
        # sum(6) -> list([1,2,3],[1,5])
        candidates = sorted(candidates)
        self.f = {}
        self.f[0] = []

        for index, num in enumerate(candidates):
            if num > target:
                break
            for key in self.f.keys():
                sum = num + key
                if sum > target:
                    break
                if sum in self.f:
                    self.f[sum].append((num, index, self.f[key]))
                else:
                    self.f[sum] = [(num, index, self.f[key])]

        listOfList = self.f.get(target)
        if listOfList == None:
            return []
        ret = self.multi(listOfList, index+1)
        ret = self.removeDuplicated(ret)
        return ret

    def removeDuplicated(self, listOfList):
        ret = set()
        for lst in listOfList:
            ret.add(tuple(lst))
        return list(ret)



    def multi(self, lst, index):
        lst = filter(lambda (num, localIndex, subList): localIndex < index, lst)
        if len(lst) == 0:
            return [[]]

        ret = []
        for num, localIndex, subList in lst:
            listOfList = self.multi(subList, localIndex)
            for list1 in listOfList:
                tmp = list(list1)
                tmp.append(num)
                ret.append(tmp)

        return ret

import unittest


class SolutionTest(unittest.TestCase):
    def testCombine(self):
        s = Solution()

        print(s.combinationSum2([2], 1))
        print(s.combinationSum2([10, 1, 2, 7, 6, 1, 5], 8))
        print(s.combinationSum2(list(range(30)), 100))

