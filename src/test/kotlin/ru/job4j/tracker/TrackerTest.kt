package ru.job4j.tracker

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

internal class TrackerTest : StringSpec({
    "Test method findAll" {
        val tracker = Tracker()
        val item = Item(name = "test")
        tracker.add(item)
        tracker.findAll() shouldBe arrayOf(Item(1, "test"))
    }

    "Test method replace" {
        val tracker = Tracker()
        val item = Item(name = "test")
        val add = tracker.add(item)
        val replaced = Item(name = "New test")
        tracker.replace(add.id, replaced)
        tracker.findAll() shouldBe arrayOf(Item(1, "New test"))
    }

    "Test method delete" {
        val tracker = Tracker()
        val item = Item(name = "test")
        val add = tracker.add(item)
        tracker.delete(add.id)
        tracker.findById(add.id) shouldBe null
    }

    "Test method findByName" {
        val tracker = Tracker()
        tracker.add(Item(name = "test"))
        tracker.add(Item(name = "test"))
        tracker.add(Item(name = "test"))
        tracker.add(Item(name = "test1"))
        tracker.add(Item(name = "test2"))
        tracker.findByName("test") shouldBe arrayOf(
            Item(1, "test"),
            Item(2, "test"),
            Item(3, "test")
        )
    }
})
