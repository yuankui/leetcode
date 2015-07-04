# coding=utf-8

class Solution:
    '''思路(v3):
    假设这些楼都在一个平面上,然后天上开始下雨,上面的楼会挡住下面的楼.因此所有的底层楼面以及地面会被打湿
    因此我们要找的关键点就是打湿的表面的左端点.

    该解法的思路是:
    1. 从上到下,枚举所有的水平线,每取一条新的水平线,需要排序
    2. 就计算该水平线未被挡的部分
        2.1 如果全挡住了,那么就直接抛弃
        2.2 如果有未被挡住的部分,将这些为被挡的部分的所有左端点加入集合
        2.3 将该线与之前的线合并,组成一条更长的线
    3. 直到枚举完所有的线
    4. 将集合中的点按照x坐标排序
    5. 结束

    # @param {integer[][]} buildings
    # @return {integer[][]}
    '''

    MAX_INT = 2 ** 64

    def getSkyline(self, buildings):
        buildings.append([0, Solution.MAX_INT, 0])
        buildings = self.sortBuildings(buildings)
        return self.fire(buildings)

    def fire(self, buildings):
        aboveLines = []
        keyPoints = []
        for building in buildings:
            left, right, height = building
            underLine = (left, right)
            splits = self.cover(aboveLines, underLine)
            leftPoints = map(lambda x: (x[0], height), splits)
            keyPoints.extend(leftPoints)
            aboveLines = self.merge(aboveLines, underLine)

        keyPoints = sorted(keyPoints, key=lambda x: x[0])

        # 特殊处理1: 去掉(0,0)点
        if keyPoints[0] == (0,0):
            keyPoints = keyPoints[1:]
        #特殊处理2: 去掉连续同高点
        retPoints = []
        lastHeight = None
        for point in keyPoints:
            x, y = point
            if y != lastHeight:
                retPoints.append(point)
            lastHeight = y
        return retPoints


    def pointIn(self, x, left, right):
        return left < x and x < right

    def pointInEq(self, x, left, right):
        return left <= x and x <= right

    def merge(self, aboveLines, underLine):
        '''将上层的线与下层的线重合部分合并,返回合并后的线列表'''
        minLeft, maxRight = underLine
        underLeft, underRight = underLine
        retLines = []
        for line in aboveLines:
            aboveLeft, aboveRight = line
            if aboveLeft > underRight or aboveRight < underLeft:
                retLines.append(line)
            else:
                minLeft = min(minLeft, aboveLeft)
                maxRight = max(maxRight, aboveRight)
        retLines.append((minLeft, maxRight))
        return retLines

    def cover(self, aboveLines, underLine):
        '''用上层的线覆盖下层的线,返回未被覆盖的部分'''
        underLeft, underRight = underLine
        points = [underLeft, underRight]

        # 打点

        startIndex = 0
        for line in aboveLines:
            aboveLeft, aboveRight = line
            if aboveRight <= underLeft or aboveLeft >= underRight:
                continue

            aboveLeftIn = self.pointInEq(aboveLeft, underLeft, underRight)
            aboveRightIn = self.pointInEq(aboveRight, underLeft, underRight)

            if aboveLeftIn: points.append(aboveLeft)
            if aboveRightIn: points.append(aboveRight)

            underLeftIn = self.pointIn(underLeft, aboveLeft, aboveRight)
            underRightIn = self.pointIn(underRight, aboveLeft, aboveRight)

            # 1. 盖两点
            if underLeftIn and underRightIn:
                return []
            # 2. 盖左点
            if underLeftIn and not underRightIn:
                startIndex = 1
                # 3. 盖右点 do nothing
                # 4. 不盖点 do nothing


        # 将点汇成线
        uncovered = []
        points = sorted(points)
        points = points[startIndex:]
        for i in range(len(points) / 2):
            left, right = points[i * 2], points[i * 2 + 1]
            if left == right:
                continue
            uncovered.append([left, right])
        return uncovered

    def sortBuildings(self, buildings):
        return sorted(buildings, key=lambda x: -x[-1])


import unittest


class SolutionTest(unittest.TestCase):
    def setUp(self):
        self.s = Solution()

    def testSort(self):
        buildings = [[2, 9, 10], [3, 7, 15], [5, 12, 12], [15, 20, 10], [19, 24, 8]]
        print self.s.sortBuildings(buildings)

    def testCover(self):
        aboveLines, underLine, expect = [(2, 3), (4, 5), (6, 9)], (3, 7), [[3, 4], [5, 6]]
        actual = self.s.cover(aboveLines, underLine)
        self.assertEqual(actual, expect)

        aboveLines, underLine, expect = [(1, 3), (4, 5), (6, 9)], (2, 7), [[3, 4], [5, 6]]
        actual = self.s.cover(aboveLines, underLine)
        self.assertEqual(actual, expect)

        aboveLines, underLine, expect = [(0, 2)], (0, 4), [[2,4]]
        actual = self.s.cover(aboveLines, underLine)
        self.assertEqual(actual, expect)

    def testMerge(self):
        aboveLines, underLine, expect = [(0, 1), (8, 9), (5, 6), (2, 4)], (3,7), [(0, 1), (8, 9), (2, 7)]
        actual = self.s.merge(aboveLines, underLine)
        self.assertEqual(expect, actual)

    def testGetSkyLines(self):
        buildings = [[2, 9, 10], [3, 7, 15], [5, 12, 12], [15, 20, 10], [19, 24, 8]]
        assert self.s.getSkyline(buildings) == [(2, 10), (3, 15), (7, 12), (12, 0), (15, 10), (20, 8), (24, 0)]
        assert self.s.getSkyline([]) == []
        assert self.s.getSkyline([[0,1,3]]) == [(0, 3), (1, 0)]
        assert self.s.getSkyline([[0,2,3],[2,5,3]]) == [(0, 3), (5, 0)]
