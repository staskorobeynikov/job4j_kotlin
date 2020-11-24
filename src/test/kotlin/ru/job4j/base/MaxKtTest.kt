package ru.job4j.base

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class MaxKtTest : StringSpec ({
    "max from 1 and 2 is 2" {
        max(1, 2) shouldBe 2
    }

    "max from 1, 2 and 3 is 3" {
        max(1, 2, 3) shouldBe 3
    }
})
