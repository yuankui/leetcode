# Definition for singly-linked list.
from collections import deque
import unittest
import math


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:

    def reverseList(self, head):
        if head == None:
            return None

        ptr = head
        stack = deque()

        while ptr != None:
            stack.append(ptr)
            ptr = ptr.next

        left, right = self.popStack(stack)
        return left

    def popStack(self, stack):
        head = stack.pop()
        p = head
        while len(stack) > 0:
            p.next = stack.pop()
            p = p.next
            p.next = None
        return head, p
