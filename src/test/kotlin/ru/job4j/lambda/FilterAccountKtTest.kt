package ru.job4j.lambda

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

internal class FilterAccountKtTest : StringSpec ({
    "Test filter name" {
        val list: List<Account> = listOf(
            Account("Ivan Bulkin", 1000.0),
            Account("Serge Tankyan", 500.0),
            Account("Ivan Tarakanov", 1725.0),
            Account("Nadya Belozyorova", -1000.0),
            Account("Iren Adler", 15.0)
        )
        val filterName = filterName(list)
        val expected: List<Account> = listOf(
            Account("Ivan Bulkin", 1000.0),
            Account("Ivan Tarakanov", 1725.0)
        )
        filterName shouldBe expected
    }
    "Test filter balance" {
        val list: List<Account> = listOf(
            Account("Ivan Bulkin", -1000.0),
            Account("Serge Tankyan", 500.0),
            Account("Ivan Tarakanov", -1725.0),
            Account("Nadya Belozyorova", 1000.0),
            Account("Iren Adler", 15.0)
        )
        val filterBalance = filterBalance(list)
        val expected: List<Account> = listOf(
            Account("Serge Tankyan", 500.0),
            Account("Nadya Belozyorova", 1000.0),
            Account("Iren Adler", 15.0)
        )
        filterBalance shouldBe expected
    }
})
