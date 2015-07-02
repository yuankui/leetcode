import unittest

class Solution:
    # @param n, an integer
    # @return an integer
    def hammingWeight(self, n):
        weight = 0
        while not n == 0:
            weight += n % 2
            n = int(n / 2)
        return weight



class SolutionTest(unittest.TestCase):
    def setUp(self):
        self.s = Solution()

    def testHammingWeight(self):
        res = self.s.hammingWeight(11)

        self.assertEqual(res, 3)
