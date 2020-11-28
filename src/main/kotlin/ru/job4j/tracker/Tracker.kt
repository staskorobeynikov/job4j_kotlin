package ru.job4j.tracker

class Tracker {
    private val items: Array<Item?> = arrayOfNulls(100)
    private var ids: Int = 1
    private var size: Int = 0

    fun add(item: Item): Item {
        item.id = ids++
        items[size++] = item
        return item
    }

    fun findAll(): Array<Item?> {
        return items.copyOfRange(0, size)
    }

    private fun indexOf(id: Int): Int {
        for (i in items.indices) {
            if (items[i]?.id == id) {
                return i
            }
        }
        return -1
    }

    fun findById(id: Int): Item? {
        val index = indexOf(id)
        return if (index != -1) items[index] else null
    }

    fun replace(id: Int, item: Item): Boolean {
        val index = indexOf(id)
        val rsl = index != -1
        if (rsl) {
            item.id = id
            items[index] = item
        }
        return rsl
    }

    fun delete(id: Int): Boolean {
        val index = indexOf(id)
        val rsl = index != -1
        if (rsl) {
            System.arraycopy(items, index + 1, items, index, size - index)
            items[size - 1] = null
            size--
        }
        return rsl
    }

    fun findByName(name: String): Array<Item?> {
        val rsl: Array<Item?> = arrayOfNulls(size)
        var index = 0
        for (i in 0 until size) {
            val item: Item? = items[i]
            if (item?.name == name) {
                rsl[index++] = item
            }
        }
        return rsl.copyOfRange(0, index)
    }
}
