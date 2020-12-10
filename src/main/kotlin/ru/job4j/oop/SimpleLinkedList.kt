package ru.job4j.oop

class SimpleLinkedList<T> : Iterable<T> {
    private var head : Node<T>? = null

    fun add(value: T) {
        val newNode = Node(value)
        if (head != null) {
            newNode.next = head
            head = newNode
        } else {
            head = newNode
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

    class Node<K>(val value: K, var next: Node<K>? = null)

    fun listIterator(): ListIterator<T> {
        return ListItr()
    }

    inner class ListItr : ListIterator<T> {
        private var lastNext: Node<T>? = head

        private var previous: Node<T>? = null

        private var nextPrevious: Node<T>? = null

        private var nextIndex: Int = 0

        override fun hasNext(): Boolean {
            return lastNext != null
        }

        override fun hasPrevious(): Boolean {
            return previous != null
        }

        override fun next(): T {
            if (!hasNext()) {
                throw NoSuchElementException()
            }
            val rsl = lastNext!!.value
            if (previous != null) nextPrevious = previous
            previous = lastNext
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
            val rsl = previous!!.value
            lastNext = previous
            nextIndex--
            return rsl
        }

        override fun previousIndex(): Int {
            return nextIndex - 1
        }
    }
}

fun main() {
    val node = SimpleLinkedList.Node<String>("Kotlin")
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
