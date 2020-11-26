package ru.job4j.base

fun defragment(array: Array<String?>): Array<String?> {
    for (i in array.indices) {
        if (array[i] == null) {
            for (j in i + 1 until array.size) {
                if (array[j] != null) {
                    array[i] = array[j]
                    array[j] = null
                    break
                }
            }
        }
    }
    return array
}
