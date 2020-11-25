package ru.job4j.base

fun max(first: Int, second: Int) = if (first > second) first else second

fun max(first: Int, second:Int, third: Int): Int = max(first, max(second, third))

fun main() {
    val rsl = max(1, 2)
    println("max from 1 and 2 is $rsl")

    val max = max(1, 2, 3)
    println("max from 1, 2 and 3 is $max")
}
