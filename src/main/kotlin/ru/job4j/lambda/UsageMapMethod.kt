package ru.job4j.lambda

import java.util.*

fun changeData(list: List<Campaign>): List<String> {
    return list.map { it.toString() }
}

fun main() {
    val list = listOf(
        Campaign("Holms Corporated", Address(
            "London", "Baker Street", 1
        ), Date(1)),
        Campaign("Moscow production", Address(
            "Moscow", "Kutuzova", 100
        ), Date(1)),
        Campaign("Berlin Brothers", Address(
            "Berlin", "Golden Street", 18
        ), Date(1))
    )

    val changeData = changeData(list)

    for (i in changeData) {
        println(i)
    }
}
