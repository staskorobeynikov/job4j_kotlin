package ru.job4j.safe

import java.util.*

class Stock {
    private var name: String? = null

    private var currency: String? = null

    private var date: Date? = null

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other != null) {
            if (javaClass != other.javaClass) return false
        }

        other as Stock

        if (name != other.name) return false
        if (currency != other.currency) return false
        if (date != other.date) return false

        return true
    }

    override fun hashCode(): Int {
        var result = 0
        if (name != null) result = name.hashCode()
        if (currency != null) result = 31 * result + currency.hashCode()
        if (date != null) result = 31 * result + date.hashCode()
        return result
    }
}
