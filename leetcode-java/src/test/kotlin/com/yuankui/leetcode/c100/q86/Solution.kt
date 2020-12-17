package com.yuankui.leetcode.c100.q86

import com.yuankui.leetcode.ListNode
import com.yuankui.leetcode.printList
import org.junit.jupiter.api.Test

class Solution {
    fun partition(head: ListNode?, x: Int): ListNode? {
        val l1 = ListNode(-1)
        l1.next = head
        
        val l2 = ListNode(-1)
        
        var p1 = l1
        var p2 = l2
        
        while (p1.next != null) {
            val next = p1.next!!
            if (next.`val` >= x) {
                p1 = p1.next!!
                continue
            }
            
            p2.next = p1.next
            p2 = p2.next!!
            p1.next = p1.next!!.next
        }
        
        p2.next = l1.next
        return l2.next
    }

    @Test
    fun test() {
        val list = ListNode.buildList(listOf(1, 4, 3, 2, 5, 2))
        val res = this.partition(list, 3)
        res.printList()
        
    }
}