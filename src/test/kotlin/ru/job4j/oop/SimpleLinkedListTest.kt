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

    "Test listIterator" {
        val list = SimpleLinkedList<String>()
        list.add("one")
        list.add("two")
        list.add("three")
        val listIterator = list.listIterator()
        listIterator.hasNext() shouldBe true
        listIterator.nextIndex() shouldBe 0
        listIterator.next() shouldBe "three"

        listIterator.hasNext() shouldBe true
        listIterator.nextIndex() shouldBe 1
        listIterator.next() shouldBe "two"

        listIterator.hasNext() shouldBe true
        listIterator.nextIndex() shouldBe 2
        listIterator.next() shouldBe "one"

        listIterator.hasNext() shouldBe false

        listIterator.hasPrevious() shouldBe true
        listIterator.previousIndex() shouldBe 2
        listIterator.previous() shouldBe "one"

        listIterator.hasPrevious() shouldBe true
        listIterator.previousIndex() shouldBe 1
        listIterator.previous() shouldBe "two"

        listIterator.hasPrevious() shouldBe true
        listIterator.previousIndex() shouldBe 0
        listIterator.previous() shouldBe "three"

        listIterator.hasPrevious() shouldBe false
    }
})
