package ru.job4j.base

fun draw(size: Int) {
    if (size % 2 == 0) return
    for (i in 0 until size) {
        for (j in 0 until size) {
            if (i == j) {
                print("\\")
            }
            else if (i + j == size - 1) {
                print("/")
            } else {
                print(" ")
            }
        }
        println()
    }
}

fun main() {
    draw(17)
}
