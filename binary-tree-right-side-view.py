# coding=utf-8

## 思路: 给node增加连个属性: deep, pos
## deep表示节点深度
## pos表示正常完全二叉树的节点值,满足
## - node.right.pos = node.pos * 2 + 1
## - node.left.pos = node.pos * 2
## 因此只需要遍历一次二叉树,然后找出每个深度中,pos值最大的节点即可

from collections import deque
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:

    maxDeep = 100
    # @param {TreeNode} root
    # @return {integer[]}
    def rightSideView(self, root):
        if root == None:
            return []

        self.maxPos = [-1] * Solution.maxDeep
        self.maxPosNode = [None] * Solution.maxDeep

        self.stack = deque()

        root.pos = 0
        root.deep = 1
        self.stack.append(root)

        while len(self.stack) > 0:
            node = self.stack.pop()

            # 子节点入栈
            if node.left != None:
                left = node.left
                left.pos = node.pos * 2
                left.deep = node.deep + 1
                self.stack.append(left)
            if node.right != None:
                right = node.right
                right.pos = node.pos * 2 + 1
                right.deep = node.deep + 1
                self.stack.append(right)

            # 处理父节点
            if node.pos > self.maxPos[node.deep]:
                self.maxPos[node.deep] = node.pos
                self.maxPosNode[node.deep] = node


        nodes = filter(lambda x:x != None, self.maxPosNode)
        values = map(lambda x:x.val, nodes)
        return values


from unittest import TestCase

class SolutionTest(TestCase):
    def testView(self):

        root = TreeNode(1)
        root.left = TreeNode(2)
        root.right = TreeNode(3)
        root.right.right = TreeNode(4)
        root.left.right = TreeNode(5)

        s = Solution()
        print(s.rightSideView(root))
