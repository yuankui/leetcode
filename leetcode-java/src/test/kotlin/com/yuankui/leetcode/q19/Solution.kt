package com.yuankui.leetcode.q19

import org.junit.jupiter.api.Test
import java.util.*

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val a: Queue<Optional<ListNode>> = ArrayDeque(n + 1)
        (0..n).forEach { 
            a.offer(Optional.empty<ListNode>())
        }
        
        var current = head

        while (current != null) {
            a.offer(Optional.of(current))
            if (a.size > n + 1) {
                a.remove()
            }
            current = current.next
        }

        val first = a.remove()
        
        if (!first.isPresent) {
            return a.remove().get().next
        }

        val second = a.remove()
        first.get().next = second.get()?.next
        return head
    }

    @Test
    fun test() {
        val a = ListNode(1)
        val b = ListNode(2)
        val c = ListNode(3)
        val d = ListNode(4)
        val e = ListNode(5)
        a.next = b
        b.next = c
        c.next = d
        d.next = e

        val res = this.removeNthFromEnd(a, 2)

        println("a = ${res}")
    }


    @Test
    fun test2() {
        val a = ListNode(1)

        val res = this.removeNthFromEnd(a, 1)

        println("a = ${res}")
    }


    @Test
    fun test3() {
        val a = ListNode(1)
        val b = ListNode(2)
        a.next = b

        val res = this.removeNthFromEnd(a, 2)

        println("a = ${res}")
    }


}