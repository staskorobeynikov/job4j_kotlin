package ru.job4j.lambda

fun filterName(list: List<Account>): List<Account> {
    return list.filter { it.name.contains("Ivan") }
}

fun filterBalance(list: List<Account>): List<Account> {
    return list.filter { it.balance > 0 }
}
