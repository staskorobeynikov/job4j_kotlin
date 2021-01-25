package ru.job4j.tracker

class AddAction : Action {
    override fun name(): String {
        return "Add new Item"
    }

    override fun execute(tracker: Tracker, input: Input): Boolean {
        val item = input.ask("Введите имя новой заявки...")
        tracker.add(Item(name = item))
        return true
    }
}
