package ru.job4j.tracker

object StartUI {
    fun init(input: Input, store: Tracker, actions: Array<Action>) {
        var run = true
        while (run) {
            printMenu()
            val check: Int = Integer.parseInt(input.ask("Введите пункт меню..."))
            run = actions[check].execute(store, input)
        }
    }

    private fun printMenu() {
        println("Меню приложения: ")
        println("0 - Добавить заявку")
        println("1 - Найти все заявки")
        println("2 - Выход")
    }
}

fun main() {
    val input = ConsoleInput()
    val tracker = Tracker()
    val actions: Array<Action> = arrayOf(
        AddAction(),
        FindAllAction(),
        ExitAction()
    )
    StartUI.init(input, tracker, actions)
}
