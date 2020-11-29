package ru.job4j.tracker

import java.util.*

object StartUI {
    private val input: Scanner = Scanner(System.`in`)

    private val store: Tracker = Tracker()

    fun init() {
        var run = true
        while (run) {
            printMenu()
            println("Введите пункт меню...")
            val check: Int = input.nextInt()
            if (check == 1) {
                addItem()
            } else if (check == 2) {
                getAll()
            } else if (check == 3) {
                run = exit()
            }
        }
    }

    private fun printMenu() {
        println("Меню приложения: ")
        println("1 - Добавить заявку")
        println("2 - Найти все заявки")
        println("3 - Выход")
    }

    private fun exit(): Boolean {
        println("Вы вышли из приложения.")
        return false
    }

    private fun getAll() {
        println("Все заявки в хранилище: ")
        val all = store.findAll()
        for (i in all.indices) {
            println(all[i])
        }
        println()
    }

    private fun addItem() {
        println("Введите имя новой заявки...")
        val item = input.next()
        store.add(Item(name = item))
    }
}

fun main() {
    StartUI.init()
}
