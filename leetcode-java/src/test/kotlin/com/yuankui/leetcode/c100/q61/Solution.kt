package com.yuankui.leetcode.c100.q61

import com.yuankui.leetcode.ListNode
import com.yuankui.leetcode.printList
import org.junit.jupiter.api.Test

/**
 * # 特殊情况
 * 
 * 1. size <= 1
 * 2. k % size == 0
 */
class Solution {
    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        fun lenAndLast(list: ListNode?): Pair<Int, ListNode?> {
            if (list == null) return Pair(0, null)
            var p: ListNode = list
            for (i in 1..Int.MAX_VALUE) {
                if (p.next == null) return Pair(i, p)
                p = p.next!!
            }
            return Pair(0, null)
        }

        val (size, last) = lenAndLast(head)
        if (size <= 1) {
            return head
        }
        
        if (k % size == 0) return head

        var p: ListNode? = ListNode(-1)
        p!!.next = head

        // 倒数第（k）为新头
        // 第(size-k)为新头
        for (i in 0 until (size - k % size)) {
            p = p!!.next
        }

        val ret = p!!.next

        p!!.next = null
        last!!.next = head
        return ret
    }

    @Test
    fun test() {
//        val list = ListNode.buildList(listOf(1, 2, 3, 4, 5))
//        val res = this.rotateRight(list, 2)
//        val list = ListNode.buildList(listOf(0, 1, 2))
//        val res = this.rotateRight(list, 4)
        val list = ListNode.buildList(listOf(1, 2))
        val res = this.rotateRight(list, 0)
        res.printList()
    }
}