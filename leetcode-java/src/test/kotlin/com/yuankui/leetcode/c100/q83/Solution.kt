package com.yuankui.leetcode.c100.q83

import com.yuankui.leetcode.ListNode
import com.yuankui.leetcode.printList
import org.junit.jupiter.api.Test

class Solution {
    fun deleteDuplicates(head: ListNode?): ListNode? {
        if (head?.next == null) {
            return head
        }
        val preHead = ListNode(-1)
        preHead.next = head


        var lastValue = head.`val`
        var a: ListNode? = head
        var p = head.next

        while (true) {
            if (p == null) break

            // 相同
            if (p!!.`val` == lastValue) {
                a!!.next = p.next
                lastValue = p.`val`
                p = p.next
                continue
            } else {
                a = p
                lastValue = p.`val`
                p = p.next
            }
        }
        
        return preHead.next
    }

    @Test
    fun test() {
        val input = ListNode.buildList(listOf(1, 2, 3, 3, 4, 4, 5))
        val res = this.deleteDuplicates(input)
        res.printList()
    }
}