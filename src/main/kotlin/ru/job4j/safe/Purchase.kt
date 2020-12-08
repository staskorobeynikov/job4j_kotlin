package ru.job4j.safe

import java.lang.StringBuilder
import java.util.*

class Purchase {
    private var name: String = ""

    private var created: Date = Date()

    private var address: Address? = null

    constructor(name: String, address: Address?) {
        this.name = name
        this.address = address
    }

    constructor()

    fun generate(list: List<Purchase>): String {
        return with(StringBuilder()) {
            append("<table>")
            append(System.lineSeparator())
            for (i in list.indices) {
                append("<tr>")
                append("<td>")
                append(list[i].name)
                append("</td>")
                append("<td>")
                append(list[i].created)
                append("</td>")
                append("<td>")
                append(list[i].address?.toString() ?: "")
                append("</td>")
                append("</tr>")
                append(System.lineSeparator())
            }
            append("</table>")
        }.toString()
    }
}

fun main() {
    val list = listOf(
        Purchase("First name", Address("London", "Baker Street", 1)),
        Purchase("Second name", null)
    )
    val generate = Purchase().generate(list)
    println(generate)
}
