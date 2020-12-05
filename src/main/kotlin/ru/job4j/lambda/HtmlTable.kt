package ru.job4j.lambda

class HtmlTable {
    private val table = Table()

    fun table(row: Int, cell: Int): String {
        return table.apply {
            startTable = "<table>"
            startRow = "<tr>"
            contentRow = row.toString()
            startCell = "<td>"
            contentCell = cell.toString()
            finishCell = "</td>"
            finishRow = "</tr>"
            finishTable = "</table>"
        }.toString()
    }
}

fun main() {
    val table = HtmlTable().table(10, 100)
    println(table)
}
