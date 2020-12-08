package com.yuankui.leetcode

class ListNode(var `val`: Int) {
    var next: ListNode? = null
    
    companion object {
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
}

fun ListNode?.printList() {
    var p = this
    while (p != null) {
        print(p.`val`)
        print(", ")
        p = p.next
    }
}

