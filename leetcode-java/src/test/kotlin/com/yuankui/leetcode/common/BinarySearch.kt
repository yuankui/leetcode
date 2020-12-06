package com.yuankui.leetcode.common

/**
 * start: inclusive
 * end: inclusive
 */
fun <T> Array<T>.binarySearch(
        start: Int,
        end: Int,
        default: Int,
        target: T,
        next: (Int, Int) -> Int = { l, r -> l + (r - l) / 2 },
        comparator: Comparator<T>
): Int {
    var result = default

    var l = start
    var r = end

    while (start <= r) {
        val mid: Int = next(l, r)
        if (comparator.compare(this[mid], target) > 0) {
            r = mid - 1
        } else if (comparator.compare(this[mid], target) < 0) {
            l = mid + 1
        } else {
            result = mid
            break
        }
    }

    return result
}