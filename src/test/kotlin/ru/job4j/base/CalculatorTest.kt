package ru.job4j.base

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class CalculatorTest : StringSpec({
    "2 + 3 = 5" {
        add(2, 3) shouldBe 5
    }

    "3 - 2 = 1" {
        subtract(3, 2) shouldBe 1
    }

    "2 * 3 = 6" {
        multiply(2, 3) shouldBe 6
    }

    "9 / 3 = 3" {
        divide(9, 3) shouldBe 3
    }
})
