# encoding: utf-8
# Definition for a binary tree node.
import unittest

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


# 核心思想: 找第一个空缺
# 比如找到一个空缺是15,那么总共就有14个
#
# 那么怎么找空缺?
# 对于一个根节点, 先判断空缺是否在左节点上,如果是,就递归进去找,否则,空缺就在右节点,递归进去找
# 怎么判断空缺是否在一个节点(包含子节点)上?
# 只需要判断该节点最右子节点深度是否等于完全树的深度,如果不等,就说明有空缺

class Solution:
    # @param {TreeNode} root
    # @return {integer}
    def countNodes(self, root):
        deep = self._countDeep(root, 'left')
        unfilled_node_number = self.getFirstUnfilledNode(root, 1, deep)
        print unfilled_node_number
        if unfilled_node_number == None:
            return 2** deep - 1
        else:
            return unfilled_node_number -1

    def countDeepLeft(self, node):
        return self._countDeep(node, 'left')

    def countDeepRight(self, node):
        return self._countDeep(node, 'right')

    def _countDeep(self, node, left_or_right):
        pointer = node
        deep = 0
        while pointer != None:
            pointer = getattr(pointer, left_or_right)
            deep += 1
        return deep


    def getFirstUnfilledNode(self, node, number, expect_deep):

        # 找到缺口啦
        if node == None:
            return number

        # 没有找到缺口,返回None
        if expect_deep == 1:
            return None

        # 如果左边没有满,那么空节点肯定在坐边
        if self.isFilled(node.left, expect_deep -1):
            right_number = number * 2 + 1
            return self.getFirstUnfilledNode(node.right, right_number, expect_deep - 1)
        else:
            # 左边节点满的,空节点在右边
            left_number = number * 2
            return self.getFirstUnfilledNode(node.left, left_number, expect_deep -1)

    def isFilled(self, node, expect_deep):
        return self._countDeep(node, 'right') == expect_deep


class TestSolutionMethods(unittest.TestCase):

    def setUp(self):
        self.solution = Solution()

    def testMain(self):
        self.testMainInner(1)
        self.testMainInner(3)
        self.testMainInner(13)
        self.testMainInner(2001)

    def testMainInner(self, number):
        expect = number
        root = self.generateTree(expect)

        actual = self.solution.countNodes(root)
        self.assertEqual(expect, actual)

    def testCountDeep(self):
        root = self.generateTree(13)
        self.assertEquals(self.solution.countDeepLeft(root), 4)

        root = self.generateTree(26)
        self.assertEquals(self.solution.countDeepLeft(root), 5)

    def generateTree(self, max_num):
        nodeMap = {}
        root = TreeNode(1)
        nodeMap[1] = root

        for i in range(2, max_num + 1):
            node = TreeNode(i)
            nodeMap[i] = node
            parent = nodeMap[int(i / 2)]
            left_or_right = 'left' if i % 2 == 0 else 'right'
            setattr(parent, left_or_right, node)

        return root

