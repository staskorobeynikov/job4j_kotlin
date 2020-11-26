package ru.job4j.base

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

internal class DefragmentKtTest : StringSpec ({
    "First element not null" {
        defragment(arrayOf(
            "first", null, "second", null, null, "third"
        )) shouldBe arrayOf(
            "first", "second", "third", null, null, null
        )
    }
    "First element is null" {
        defragment(arrayOf(
            null, "first", null, "second", null, "third"
        )) shouldBe arrayOf(
            "first", "second", "third", null, null, null
        )
    }
    "First and last element is null" {
        defragment(arrayOf(
            null, "first", null, "second", null, "third", null
        )) shouldBe arrayOf(
            "first", "second", "third", null, null, null, null
        )
    }
})
