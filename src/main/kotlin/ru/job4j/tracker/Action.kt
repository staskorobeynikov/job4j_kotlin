package ru.job4j.tracker

interface Action {
    fun execute(tracker: Tracker, input: Input): Boolean
}
