package test

import java.io.File
import kotlin.streams.toList

fun main() {
    val filePath = "/Users/yuankui/Downloads/新查询-138858928-1597218438580.txt"

    val res = File(filePath)
            .readLines()
            .stream()
            .skip(1)
            .map {
                val tokens = it.split("\t")
                assert(tokens.size == 13)
                val (ctime, id, is_leaf, level, name) = tokens
                val parent_id = tokens[5]

                "$id|$level|$parent_id|$name"
            }.toList()
            .joinToString(",")

    println("res = $res")
}