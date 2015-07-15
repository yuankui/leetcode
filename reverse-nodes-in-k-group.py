# Definition for singly-linked list.

from collections import deque


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

    def __str__(self):
        return str(self.val)


class Solution:
    # @param {ListNode} head
    # @param {integer} k
    # @return {ListNode}
    def reverseKGroup(self, head, k):
        veryHead = ListNode(0)
        veryHead.next = head

        if head == None:
            return head
        node = head
        stack = deque()
        lastTail = veryHead

        count = 0
        while node != None:
            stack.append(node)
            count += 1
            node = node.next
            if count % k == 0:
                tmpHead, tmpTail = self.reverse(stack, node)
                lastTail.next = tmpHead
                lastTail = tmpTail

        return veryHead.next

    def reverse(self, stack, nextHead):
        head = stack.pop()
        node = head

        while len(stack) > 0:
            tmp = stack.pop()
            node.next, node = (tmp, tmp)

        node.next = nextHead
        return head, node


import unittest


class SolutionTest(unittest.TestCase):
    def testReverseK(self):
        s = Solution()
        root = ListNode(1)
        root.next = ListNode(2)
        root.next.next = ListNode(3)
        root.next.next.next = ListNode(4)
        root.next.next.next.next = ListNode(5)
        root.next.next.next.next.next = ListNode(6)
        root.next.next.next.next.next.next = ListNode(7)

        ret = s.reverseKGroup(root, 3)
        ret = s.reverseKGroup(ListNode(1), 1)
        pass
