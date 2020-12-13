package com.yuankui.leetcode.c100.q82

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
        
        var a: ListNode? = preHead
        var b = preHead.next
        
        var lastValue = head.`val`
        
        var p = head.next
        
        var accSame = false
        
        while (true) {
            if (p == null) break
            
            // 相同
            if (p!!.`val` == lastValue) {
                a!!.next = p
                b = p
                accSame = true
                lastValue = p.`val`
                p = p.next
                
                continue
            }
            
            // 尾不相同
            if (p!!.`val` != lastValue &&!accSame) {
                a = b
                b = p
                
                lastValue = p.`val`
                p = p.next

                continue
            }
            
            // 切换
            if (p!!.`val` != lastValue && accSame) {
                b = p
                a!!.next = b
                accSame = false
                
                lastValue = p.`val`
                p = p.next

                continue
            }
        }
        
        if (accSame) {
            a!!.next = null
        }
        return preHead.next
    }

    @Test
    fun test() {
//        val list = ListNode.buildList(listOf(1, 2, 3, 3, 4, 4, 5))
//        val list = ListNode.buildList(listOf(1, 1, 1, 2, 3))
        val list = ListNode.buildList(listOf(1, 1))
        
        val res = this.deleteDuplicates(list)
        res.printList()
    }
}