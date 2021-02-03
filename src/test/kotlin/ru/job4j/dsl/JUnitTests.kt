package ru.job4j.dsl

import org.junit.Assert.*
import org.junit.Test

class JUnitTests {
    /**
     * Имитация сравнения - передаваемые объекты равны
     *
     * object eq expected
     */
    infix fun Any.eq(expected: Any) = assertEquals(this, expected)

    /**
     * Имитация сравнения - передаваемые объекты не равны
     *
     * object notEq expected
     */
    infix fun Any.notEq(expected: Any) = assertNotEquals(this, expected)

    /**
     * Имитация сравнения - список содержит передаваемый элемент
     *
     * list contains values
     */
    infix fun List<Any>.contains(values: Any) = assertTrue(this.contains(values))

    @Test
    fun whenEqualsTwoNumbers() = 1 eq 1

    @Test
    fun whenNotEqualsTwoNumbers() = 1 notEq 2

    @Test
    fun whenListContainsValues() = listOf<Number>(1, 4, 7, 0) contains 0
}