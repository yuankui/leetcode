package com.yuankui.leetcode.q21

import org.junit.jupiter.api.Test

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        var p1 = l1
        var p2 = l2
        var head: ListNode?
        var current: ListNode

        if (p1 == null) return p2
        if (p2 == null) return p1



        if (p1.`val` < p2.`val`) {
            head = p1
            p1 = p1.next
        } else {
            head = p2
            p2 = p2.next
        }

        current = head

        while (true) {
            if (p1 == null) {
                current.next = p2
                return head
            }
            if (p2 == null) {
                current.next = p1
                return head
            }

            if (p1.`val` < p2.`val`) {
                current.next = p1
                p1 = p1.next
            } else {
                current.next = p2
                p2 = p2.next
            }

            current = current.next!!
        }
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

    fun printNode(node: ListNode?) {
        var p = node
        while (p != null) {
            print(p.`val`)
            print(", ")
            p = p.next
        }
    }

    @Test
    fun test() {
        val l1 = buildList(listOf(1, 2, 4))
        val l2 = buildList(listOf(1, 3, 4))
        val res = this.mergeTwoLists(l1, l2)

        printNode(res)
    }
}