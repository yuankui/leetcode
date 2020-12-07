package com.yuankui.leetcode.q50

import org.junit.jupiter.api.Test
import kotlin.math.absoluteValue

/**
 * TODO 二分法
 */
class Solution {
    fun myPow(x: Double, n: Int): Double {
        if (x == 1.0) {
            return x
        }
        var r = 1.0
        var nn: Long = n.toLong()
        
        if (x == -1.0)
            nn = nn % 2
        
        for (i in 0 until Math.abs(nn)) {
            if (n > 0)
                r = r * x
            else 
                r = r / x
            
            if (r == 0.0) break
        }
        return r
    }
    
    @Test
    fun test() {
        val r = myPow(-1.0, 2147483640)
        println("r = ${r}")
    }
}