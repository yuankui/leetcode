# Definition for singly-linked list.
import unittest
from collections import deque
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    # @param {ListNode} head
    # @return {void} Do not return anything, modify head in-place instead.
    def reorderList(self, head):
        if head == None:
            return;
        deq = self.linkToDeque(head)
        deq = self.reorderDeque(deq)
        head = self.dequeToLink(deq)
        pass

    def linkToDeque(self, head):
        arr = deque()
        p = head
        while p != None:
            arr.append(p)
            p = p.next
        return arr

    def dequeToLink(self, deq):
        head = deq.popleft()
        last = head

        for this in deq:
            last.next = this
            last = this
        last.next = None

        return head

    def reorderDeque(self, arr):
        newDeque = deque()
        operation = 'popleft'
        while len(arr) != 0:
            element = getattr(arr, operation)()
            newDeque.append(element)
            operation = 'popleft' if operation == 'pop' else 'pop'

        return newDeque


class SolutionTest(unittest.TestCase):
    def testReorder(self):
        s = Solution()
        head = self.generateList([1,2,3,4,5])
        s.reorderList(head)
        head = self.generateList([1])
        s.reorderList(head)
        pass


    def generateList(self, lst):
        head = ListNode(0)
        last = head
        for one in lst:
            node = ListNode(one)
            last.next = node
            last = node
        return head.next




