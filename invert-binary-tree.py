# Definition for a binary tree node.
import unittest

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

    def __str__(self):
        return str(self.val)

class Solution:
    # @param {TreeNode} root
    # @return {TreeNode}
    def invertTree(self, root):
        if root == None:
            return
        self.invertTree(root.left)
        self.invertTree(root.right)
        root.left, root.right = root.right, root.left
        return root

class SolutionTest(unittest.TestCase):
    def setUp(self):
        self.s = Solution()

    def testSolution(self):
        root = TreeNode(1)
        print self.s.invertTree(root)