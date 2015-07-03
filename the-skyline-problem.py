# coding=utf-8
class Solution:
    '''思路:
    0. 做准备工作,使其满足一下需求
        0.1 根据X坐标列出所有经过该坐标的竖线
        0.2 根据点(X,Y)列出所有经过该点的线段
            0.2.1 找出所有的横线
            0.2.2 枚举所有的横线,然后与所有的竖线进行相交,得到交点,建立 点->list(线)的hash
                0.2.2.1 这里有个优化就是步骤,竖线按x轴排序,然后按二分查找,过滤掉那些不在横线x范围内的竖线
        0.3 列出所有Y坐标为Y的点(排序)
            0.3.1 根据0.2.2 步骤得出的点,建立Y->点的索引

    2. 从最左下角开始走路,转弯描点,几个原则
        2.1 往上走,上->右
        2.2 往下走,右>下(能右转就右转,不能右转就走到底(地平线))
        2.3 往右走,上>右->下
        判断能否
        2.4 下走的方法:永远都可以下走
        2.5 上走的方法:看是否右经过该X的竖线,取Y最大的,走到底
        2.6 右走的方法:对于所有经过该点的横线,去X最小的(不等于当前X),走过去

    # @param {integer[][]} buildings
    # @return {integer[][]}
    '''

    def getSkyline(self, buildings):
        pass

    def getAllVerticalLines(self, buildings):
        lines = []
        for building in buildings:
            line1 = (building[0], building[2])
            line2 = (building[1], building[2])
            lines.append(line1)
            lines.append(line2)

        lines = sorted(lines, key=lambda x: x[0])
        return lines


import unittest


class SolutionTest(unittest.TestCase):
    def setUp(self):
        self.s = Solution()

    def testGetAllVerticalLines(self):
        buildings = [[2, 9, 10], [3, 7, 15], [5, 12, 12], [15, 20, 10], [19, 24, 8]]
        print self.s.getAllVerticalLines(buildings)
