# Definition for a binary tree node.
from collections import deque

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
    def __str__(self):
        return str(self.val)

class Solution:
    # @param {TreeNode} root
    # @return {integer[]}
    def postorderTraversal(self, root):
        if root == None:
            return []
        stack = deque()
        stack.append(root)
        res = []
        while len(stack) > 0:
            p = stack.pop()
            if p.right == None and p.left == None:
                res.append(p.val)
                continue
            stack.append(p)
            if p.right != None:
                stack.append(p.right)
            if p.left != None:
                stack.append(p.left)
            p.left = None
            p.right = None

        return res

import unittest

class SolutionTest(unittest.TestCase):
    def testPostOrder(self):
        p = TreeNode(1)
        p.left = TreeNode(2)
        p.right = TreeNode(3)
        p.right.left = TreeNode(4)
        p.right.right = TreeNode(5)
        p.right.left.left = TreeNode(6)
        p.right.left.right = TreeNode(7)
        p.right.right.right = TreeNode(8)

        s = Solution()
        assert [2, 6, 7, 4, 8, 5, 3, 1] == s.postorderTraversal(p)


