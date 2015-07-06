# coding=utf-8
__author__ = 'yuankui'


def binarySearch(items, key, target, start, end, delta=0):
    targetValue = key(target) + delta
    startValue = key(items[start])
    endValue = key(items[end])
    while True:
        # 终止条件
        if start + 1 >= end:
            if targetValue == startValue:
                return True, start
            elif targetValue == endValue:
                return True, end
            elif targetValue < startValue:
                return False, start - 1
            elif targetValue > startValue:
                return False, start

        middle = (start + end) / 2
        middleValue = key(items[middle])

        if targetValue < middleValue:
            endValue = middleValue
            end = middle
        elif targetValue > middleValue:
            startValue = middleValue
            start = middle
        else:
            return True, middle

import unittest


class Test(unittest.TestCase):
    def testBinarySearch(self):
        items = ['ga', 'ha', 'ib', 'jb', 'kc']
        length = len(items)
        target = 'ib'

        found, pos = binarySearch(items, self.getKey, target, 0, length - 1, -0.5)
        assert (found, pos) == (False, 1)
        found, pos = binarySearch(items, self.getKey, target, 0, length - 1, 0.5)
        assert (found, pos) == (False, 3)
        found, pos = binarySearch(items, self.getKey, 'gc', 0, length - 1)
        assert (found, pos) == (True, 4)

    def getKey(self, x):
        ret = ord(x[1])
        return ret
