# Definition for singly-linked list.
from collections import deque
import unittest


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    # @param {ListNode} head
    # @param {integer} m
    # @param {integer} n
    # @return {ListNode}
    def reverseBetween(self, head, m, n):
        very_head = ListNode(0)
        very_head.next = head
        head = very_head

        index = 0
        ptr = head
        last_ptr = head
        stack = deque()

        while ptr != None:
            print "lllllllll"

            if index < m:
                last_ptr = ptr
            elif m <= index and index <= n:
                stack.append(ptr)
            else:
                break
            ptr = ptr.next
            index += 1

        first, last = self.popStack(stack)
        last_ptr.next = first
        last.next = ptr

        return very_head.next

    def popStack(self, stack):
        head = stack.pop()
        p = head
        while len(stack) > 0:
            p.next = stack.pop()
            p = p.next
            p.next = None
        return head, p


class SolutionTest(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

    def reverseBetween(self, s, m, n):
        head = ListNode(s[0])
        p = head

        for i in s[1:]:
            p.next = ListNode(i)
            p = p.next

        head = self.solution.reverseBetween(head, m, n)
        pass

    def testReverse(self):
        self.reverseBetween([1, 2, 3, 4, 5, 6], 2, 4)
        self.reverseBetween([3, 5], 1, 2)
