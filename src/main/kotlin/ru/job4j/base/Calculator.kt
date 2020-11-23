package ru.job4j.base

import java.lang.UnsupportedOperationException

fun add(first : Int, second : Int) : Int {
    return first + second
}

fun subtract(first : Int, second : Int) : Int {
    return first - second
}

fun multiply(first : Int, second : Int) : Int {
    return first * second
}

fun  divide(first : Int, second : Int) : Int {
    if (second == 0) {
        throw UnsupportedOperationException("Недопустимая операция")
    }
    return first / second
}

fun main() {
    val plus = add(2, 3)
    println("2 + 3 = $plus")

    val subtract = subtract(3, 2)
    println("3 - 2 = $subtract")

    val multiply = multiply(2, 3)
    println("2 * 3 = $multiply")

    val divide = divide(9, 3)
    println("9 / 3 = $divide")
}


