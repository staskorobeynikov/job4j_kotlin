package ru.job4j.oop

class SimpleLinkedList<T> : Iterable<T> {
    private var head : Node<T>? = null
    private var last : Node<T>? = null

    fun add(value: T) {
        val tmp = head
        val newNode = Node(null, value, tmp)
        head = newNode
        if (tmp == null) {
            last = newNode
        } else {
            tmp.prev = newNode
        }
    }

    override fun iterator(): Iterator<T> {
        return LinkedIt()
    }
    inner class LinkedIt : Iterator<T> {
        private var lastNext: Node<T>? = head

        override fun hasNext(): Boolean {
            return lastNext != null
        }

        override fun next(): T {
            if (!hasNext()) {
                throw NoSuchElementException()
            }
            val rsl = lastNext!!.value
            lastNext = lastNext?.next
            return rsl
        }
    }

    class Node<K>(var prev: Node<K>? = null, val value: K, var next: Node<K>? = null)

    fun listIterator(): ListIterator<T> {
        return ListItr()
    }

    inner class ListItr : ListIterator<T> {
        private var lastNext: Node<T>? = head

        private var nextIndex: Int = 0

        override fun hasNext(): Boolean {
            return lastNext != null
        }

        override fun hasPrevious(): Boolean {
            return nextIndex > 0
        }

        override fun next(): T {
            if (!hasNext()) {
                throw NoSuchElementException()
            }
            val rsl = lastNext!!.value
            lastNext = lastNext?.next
            nextIndex++
            return rsl
        }

        override fun nextIndex(): Int {
            return nextIndex
        }

        override fun previous(): T {
            if (!hasPrevious()) {
                throw NoSuchElementException()
            }
            lastNext = if (lastNext == null) last else lastNext?.prev
            nextIndex--
            return lastNext!!.value
        }

        override fun previousIndex(): Int {
            return nextIndex - 1
        }
    }
}

fun main() {
    val node = SimpleLinkedList.Node(null, "Kotlin")
    println(node.value)
    println()
    val list = SimpleLinkedList<String>()
    list.add("Java")
    list.add("Kotlin")
    list.add("Scala")
    for (value in list) {
        println(value)
    }
    val listIterator = list.listIterator()
    println(listIterator.hasPrevious())
    listIterator.next()
    println(listIterator.previous())
}
