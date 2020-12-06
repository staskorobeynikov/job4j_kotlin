package ru.job4j.lambda

import java.lang.StringBuilder

class EmailService {
    fun emailTo(message: Message): String {
        return with(StringBuilder()) {
            append("Subject : ")
            append(message.email)
            append(" ")
            append("Body : ")
            append("Hello, ")
            append(message.username)
            append(" ")
            append("You win!")
        }.toString()
    }
}

fun main() {
    val emailTo = EmailService().emailTo(Message("root", "root@local"))
    println(emailTo)
}
