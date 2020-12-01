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
}
