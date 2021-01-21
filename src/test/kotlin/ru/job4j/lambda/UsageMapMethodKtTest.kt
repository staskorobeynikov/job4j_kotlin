package ru.job4j.lambda

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import java.util.*

internal class UsageMapMethodKtTest : StringSpec ({
    "Test method for change Data" {
        val list = listOf(
            Campaign("Holms Corporated", Address(
                "London", "Baker Street", 1
            ), Date(1)
            ),
            Campaign("Moscow production", Address(
                "Moscow", "Kutuzova", 100
            ), Date(1)
            ),
            Campaign("Berlin Brothers", Address(
                "Berlin", "Golden Street", 18
            ), Date(1)
            )
        )
        val expected = listOf(
            Campaign("Holms Corporated", Address(
                "London", "Baker Street", 1
            ), Date(1)
            ).toString(),
            Campaign("Moscow production", Address(
                "Moscow", "Kutuzova", 100
            ), Date(1)
            ).toString(),
            Campaign("Berlin Brothers", Address(
                "Berlin", "Golden Street", 18
            ), Date(1)
            ).toString()
        )
        val changeData = changeData(list)
        changeData shouldBe expected
    }
})
