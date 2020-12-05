package ru.job4j.lambda

fun sum(list: List<Int>): Int {
    return list
        .stream()
        .filter{ it % 2 == 0}
        .map { it + 1 }
        .reduce { t: Int, u: Int -> t.plus(u) }
        .orElse(0)
}

fun count(list: List<Int>): Long {
    return list
        .stream()
        .filter{ it % 2 == 0}
        .map { it + 1 }
        .count()
}
