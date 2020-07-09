package com.yuankui.leetcode

class Q0009PalindromeNumber {
    fun isPalindrome(x: Int): Boolean {
        val str = x.toString()
        return str == str.reversed()
    }
}