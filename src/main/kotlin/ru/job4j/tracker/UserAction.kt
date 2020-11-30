package ru.job4j.tracker

import java.util.*

class UserAction private constructor() {
    companion object {
        fun getAll(store: Tracker) {
            println("Все заявки в хранилище: ")
            val all = store.findAll()
            for (i in all.indices) {
                println(all[i])
            }
            println()
        }
        fun addItem(input: Scanner, store: Tracker) {
            println("Введите имя новой заявки...")
            val item = input.next()
            store.add(Item(name = item))
        }
        fun exit(): Boolean {
            println("Вы вышли из приложения.")
            return false
        }
    }
}
