# encoding: utf8
# Definition for singly-linked list.
import unittest
import copy


class ListNode2:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    # @param {ListNode} l1
    # @param {ListNode} l2
    # @return {ListNode}
    def addTwoNumbers(self, l1, l2):
        self.l1 = l1
        p1 = l1
        p2 = l2
        l3 = self.newNode()
        p3 = l3
        p3Backup = p3
        left = 0

        while True:
            num1 = self.getNum(p1)
            num2 = self.getNum(p2)
            total = left + num1 + num2
            p3.val = total % 10
            left = total / 10

            if p1:
                p1 = p1.next
            if p2:
                p2 = p2.next
            p3Backup = p3
            p3.next = self.newNode()
            p3 = p3.next

            if p1 == None and p2 == None and left == 0:
                break
        p3Backup.next = None
        return l3

    def newNode(self):
        node = copy.copy(self.l1)
        node.val = 0
        node.next = None
        return node

    def getNum(self, p):
        if p == None:
            return 0
        else:
            return p.val


class SolutionTest(unittest.TestCase):
    def setUp(self):
        self.s = Solution()

    def generateLinkedList(self, nums):
        head = ListNode2(0)
        p = head
        pBackup = p

        for num in nums:
            p.val = num
            p.next = ListNode2(0)
            pBackup = p
            p = p.next

        pBackup.next = None

        return head

    def testIt(self):
        list1 = self.generateLinkedList([1, 2, 3, 4, 5])
        list2 = self.generateLinkedList([3, 4, 5, 6, 7, 9])
        ret = self.s.addTwoNumbers(list1, list2)

        list1 = self.generateLinkedList([0])
        list2 = self.generateLinkedList([0])

        ret = self.s.addTwoNumbers(list1, list2)

        list1 = self.generateLinkedList([2, 4, 3])
        list2 = self.generateLinkedList([5, 6, 4])

        ret = self.s.addTwoNumbers(list1, list2)
        pass
