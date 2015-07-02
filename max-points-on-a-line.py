# encoding: utf-8
import unittest
# Definition for a point.
class Point:
    def __init__(self, a=0, b=0):
        self.x = a
        self.y = b


# 计算所有两点直接的直线方程,将直线方程放入hash中
# 然后统计落入同一个hash中最多的直线上面的点数
class Solution:
    # @param {Point[]} points
    # @return {integer}
    def maxPoints(self, points):
        if len(points) == 0:
            return 0
        if len(points) == 1:
            return 1
        hash = {}

        for i in range(len(points)):
            for j in range(i + 1, len(points)):
                p1 = points[i]
                p2 = points[j]
                line = self.calcLine(p1, p2)

                pts = [i, j]
                if line in hash:
                    hash[line] += pts
                else:
                    hash[line] = pts

        pointNums = map(lambda x: len(set(x)), hash.values())
        print hash.keys()
        return max(pointNums)

    def calcLine(self, p1, p2):
        deltaX = p1.x - p2.x
        if deltaX == 0:
            return (p1.x, None)
        else:
            angle = (p1.y - p2.y) / (p1.x - p2.x)
            delta = (p1.x * p2.y - p2.x * p1.y) / (p1.x - p2.x)
            return (delta, angle)


class SolutionTest(unittest.TestCase):
    def setUp(self):
        self.s = Solution()

    def testMaxPoints(self):
        pts = [(0, 0), (1, 1), (1, 2), (2, 2), (3, 2), (3, 3)]
        self.maxPoints(pts, 4)

        pts = [[0, 9], [138, 429], [115, 359], [115, 359], [-30, -102], [230, 709], [-150, -686], [-135, -613],
               [-60, -248], [-161, -481], [207, 639], [23, 79], [-230, -691], [-115, -341], [92, 289], [60, 336],
               [-105, -467], [135, 701], [-90, -394], [-184, -551], [150, 774]]
        self.maxPoints(pts, 12)

    def maxPoints(self, pts, expect):
        points = map(lambda (x, y): Point(x, y), pts)
        res = self.s.maxPoints(points)
        self.assertEqual(res, expect)
