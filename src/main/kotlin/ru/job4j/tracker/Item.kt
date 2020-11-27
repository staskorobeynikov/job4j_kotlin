package ru.job4j.tracker

class Item {
    private var id: Int = 0
    private var name: String = ""

    constructor(name: String) {
        this.name = name
    }

    constructor(id: Int, name: String) {
        this.id = id
        this.name = name
    }

    fun getId() = id

    fun setId(id: Int) {
        this.id = id
    }

    fun getName() = name

    fun setName(name: String) {
        this.name = name
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Item

        if (id != other.id) return false
        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + name.hashCode()
        return result
    }

    override fun toString(): String {
        return "Item(id=$id, name='$name')"
    }
}
