package ru.job4j.tracker

class ExitAction : Action {
    override fun execute(tracker: Tracker, input: Input): Boolean {
        println("Вы вышли из приложения.")
        return false
    }
}
