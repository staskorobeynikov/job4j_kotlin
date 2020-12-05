package ru.job4j.lambda

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

internal class SummingKtTest : StringSpec ({
    "Filter and map sum" {
        val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val sum = sum(list)
        sum shouldBe 35
    }

    "Filter and map count" {
        val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val sum = count(list)
        sum shouldBe 5
    }
})
