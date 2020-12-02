package ru.job4j.tracker

class FindAllAction : Action {
    override fun execute(tracker: Tracker, input: Input): Boolean {
        println("Все заявки в хранилище: ")
        val all = tracker.findAll()
        for (i in all.indices) {
            println(all[i])
        }
        println()
        return true
    }
}
