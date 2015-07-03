#encoding: utf-8

import unittest
from collections import deque

class Square:
    def __init__(self, height, width):
        self.height = height
        self.width = width

class Solution:
    '''构造一个高度升序的Square栈不断地往栈中加Square,直到打破升序这个节奏
    如果遇到一个打破升序的小伙子,那么就将那些高度比他高的Square出栈,并且计算这些Square的面积
    计算完了之后,新建一个Square,高度=当前height高度,宽度=出栈的Square宽度和(相当于把之前比较高的方块的头削掉,然后和当前的方块组合成一个更宽的方块)
    '''

    # @param {integer[]} height
    # @return {integer}
    def largestRectangleArea(self, heights):
        self.squareList = deque()
        self.maxArea = 0
        for height in heights:
            self.addHeight(height)

        self.addHeight(0)
        return self.maxArea

    def addHeight(self, height):
        popped = deque()
        while len(self.squareList) > 0:
            square = self.squareList.pop()
            if square.height > height:
                # popped的高度刚好跟squareList相反,是降序的
                popped.append(square)
            else:
                self.squareList.append(square)
                break

        area,width = self.calcMaxSquare(popped)
        self.squareList.append(Square(height, width + 1))
        self.maxArea = max(area, self.maxArea)

    def calcMaxSquare(self, popped):
        '''这个数列是按照降序的'''
        width = 0
        maxArea = 0
        for square in popped:
            width += square.width
            area = width * square.height
            maxArea = max(area, maxArea)
        return maxArea, width

class SolutionTest(unittest.TestCase):
    def testLargest(self):
        s = Solution()
        expect, arr = 10, [2, 1, 5, 6, 2, 3]
        actual = s.largestRectangleArea(arr)
        self.assertEqual(actual, expect)

        expect, arr = 20, [3,6,5,7,4,8,1,0]
        actual = s.largestRectangleArea(arr)
        self.assertEqual(actual, expect)


