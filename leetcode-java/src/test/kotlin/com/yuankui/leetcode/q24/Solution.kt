package com.yuankui.leetcode.q24

import com.yuankui.leetcode.ListNode
import com.yuankui.leetcode.printList
import org.junit.jupiter.api.Test


class Solution {
    fun swapPairs(head: ListNode?): ListNode? {
        val preHead = ListNode(-1)
        preHead.next = head
        
        var current = preHead

        while (true) {
            if (current.next == null) break
            if (current.next!!.next == null) break
            
            val a = current.next!!
            val b = current.next!!.next!!
            val c = current.next!!.next!!.next
            
            current.next = b
            b.next = a
            a.next = c
            
            current = a
        }
        
        return preHead.next
    }
    
    @Test
    fun test() {
        val list = buildList(listOf(1, 2, 3, 4, 5))

        val res = this.swapPairs(list)
        
        res.printList()
    }

    fun buildList(vals: List<Int>): ListNode? {
        var node: ListNode? = null

        vals.reversed()
                .forEach {
                    val n = ListNode(it)
                    if (node == null) {
                        node = n
                    } else {
                        n.next = node
                        node = n
                    }
                }

        return node
    }
    
    
}