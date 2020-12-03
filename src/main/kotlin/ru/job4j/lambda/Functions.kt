package ru.job4j.lambda

fun main() {
    val inc = { x: Int -> x + 1 }
    println(inc(12))

    val square = { x: Int -> x * x }
    println(square(12))
}
