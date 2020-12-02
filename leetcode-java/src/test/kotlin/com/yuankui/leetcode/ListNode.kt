package com.yuankui.leetcode

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun ListNode?.printList() {
    var p = this
    while (p != null) {
        print(p.`val`)
        print(", ")
        p = p.next
    }
}