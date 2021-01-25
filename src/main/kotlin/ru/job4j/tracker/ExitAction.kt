package ru.job4j.tracker

class ExitAction : Action {
    override fun name(): String {
        return "Exit"
    }

    override fun execute(tracker: Tracker, input: Input): Boolean {
        println("Вы вышли из приложения.")
        return false
    }
}
