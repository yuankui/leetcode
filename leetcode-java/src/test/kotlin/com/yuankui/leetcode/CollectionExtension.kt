package com.yuankui.leetcode

fun <T> T.addTo(collection: MutableCollection<T>) {
    collection.add(this)
}