package ru.job4j.safe

class Handbook {
    val cities: List<String> by lazy { loadCities() }

    private fun loadCities(): List<String> = listOf("Minsk", "Moscow", "Bryansk")
}

fun main() {
    val handbook = Handbook()
    println(handbook.cities)
}
