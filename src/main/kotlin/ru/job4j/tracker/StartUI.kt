package ru.job4j.tracker

import java.util.*

object StartUI {
    fun init(input: Scanner, store: Tracker) {
        var run = true
        while (run) {
            printMenu()
            println("Введите пункт меню...")
            val check: Int = input.nextInt()
            if (check == 1) {
                UserAction.addItem(input, store)
            } else if (check == 2) {
                UserAction.getAll(store)
            } else if (check == 3) {
                run = UserAction.exit()
            }
        }
    }

    private fun printMenu() {
        println("Меню приложения: ")
        println("1 - Добавить заявку")
        println("2 - Найти все заявки")
        println("3 - Выход")
    }
}

fun main() {
    val input = Scanner(System.`in`)
    val store = Tracker()
    StartUI.init(input, store)
}
