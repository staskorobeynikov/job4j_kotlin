package ru.job4j.dsl

class ItemStore: Store<Item> {
    private var ids: Int = 1
    private val store = mutableListOf<Item>()

    override fun save(model: Item): Item {
        model.id = ids++
        store.add(model)
        return model
    }
}
