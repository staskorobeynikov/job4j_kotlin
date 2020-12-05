package ru.job4j.lambda

class Table {
    var startTable: String = ""
    var startRow: String = ""
    var contentRow: String = ""
    var startCell: String = ""
    var contentCell: String = ""
    var finishCell: String = ""
    var finishRow: String = ""
    var finishTable: String = ""

    override fun toString(): String {
        return "$startTable$startRow$contentRow$startCell$contentCell$finishCell$finishRow$finishTable"
    }
}
