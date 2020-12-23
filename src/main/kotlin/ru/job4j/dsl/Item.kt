package ru.job4j.dsl

data class Item (var id: Int = 0, var name: String = "")

fun Item.save(): Item {
    val i = this
    return ItemStore().save(i)
}

fun main() {
    val item = Item(1, "test")
    val save = item.save()
    println(save)
}
