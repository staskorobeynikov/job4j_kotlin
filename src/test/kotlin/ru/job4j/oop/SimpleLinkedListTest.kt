package ru.job4j.oop

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

internal class SimpleLinkedListTest : StringSpec({
    "Test add and iterator" {
        val list = SimpleLinkedList<String>()
        list.add("one")
        list.add("two")
        list.add("three")
        val iterator = list.iterator()
        iterator.hasNext() shouldBe true
        iterator.next() shouldBe "three"
        iterator.hasNext() shouldBe true
        iterator.next() shouldBe "two"
        iterator.hasNext() shouldBe true
        iterator.next() shouldBe "one"
        iterator.hasNext() shouldBe false
    }
})
