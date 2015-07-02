import unittest


class Solution:
    # @param {integer} A
    # @param {integer} B
    # @param {integer} C
    # @param {integer} D
    # @param {integer} E
    # @param {integer} F
    # @param {integer} G
    # @param {integer} H
    # @return {integer}
    def computeArea(self, A, B, C, D, E, F, G, H):
        totalArea = self.computeSingleArea(A, B, C, D) + self.computeSingleArea(E, F, G, H)
        deltaX = self.computeCommon([A, C], [E, G])
        deltaY = self.computeCommon([B, D], [F, H])

        commonArea = deltaX * deltaY
        return totalArea - commonArea

    def computeSingleArea(self, x1, y1, x2, y2):
        return abs(x1 - x2) * abs(y1 - y2)

    def computeCommon(self, line1, line2):
        line1 = sorted(line1)
        line2 = sorted(line2)

        if line1[0] > line2[0]:
            line1, line2 = line2, line1

        if line1[1] < line2[0]:
            return 0
        else:
            return min(line1[1], line2[1]) - line2[0]


class SolutionTest(unittest.TestCase):
    def setUp(self):
        self.s = Solution()

    def testComputeCommon(self):
        common = self.s.computeCommon([3, -3], [9, 0])
        self.assertEqual(common, 3)

    def testComputeArea(self):
        res = self.s.computeArea(-2, -2, 2, 2, -2, -2, 2, 2)
        self.assertEqual(res, 16)
