package ru.job4j.tracker

object StartUI {
    fun init(input: Input, store: Tracker, actions: Array<Action>) {
        var run = true
        while (run) {
            printMenu(actions)
            val check = Integer.parseInt(input.ask("Введите пункт меню..."))
            run = actions[check].execute(store, input)
        }
    }

    private fun printMenu(actions: Array<Action>) {
        println("Меню приложения: ")
        for (i in actions.indices) {
            println(i.toString() + ". " + actions[i].name())
        }
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
