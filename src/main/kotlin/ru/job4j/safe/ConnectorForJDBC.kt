package ru.job4j.safe

import java.sql.Connection
import java.sql.DriverManager

class ConnectorForJDBC {
    private lateinit var connection : Connection

    private fun getConnection(url: String, login: String, password: String): Connection {
        connection = DriverManager.getConnection(url, login, password)
        return connection
    }

    fun execute(sql: String, type: String, url: String, login: String, password: String): String = when (type) {
        "select" -> {
            var value = 0
            getConnection(url, login, password).createStatement().use { st ->
                st.executeQuery(sql).use { rst ->
                    while (rst.next()) {
                        value++
                    }
                }
            }
            "В таблице содержится: $value записей."
        }
        "insert" -> {
            val value = getConnection(url, login, password).createStatement().use {
                    st -> st.executeUpdate(sql)
            }
            "Было добавлено: $value записей."
        }
        "update" -> {
            val value = getConnection(url, login, password).createStatement().use {
                    st -> st.executeUpdate(sql)
            }
            "Было обновлено: $value записей."
        }
        "delete" -> {
            val value = getConnection(url, login, password).createStatement().use {
                    st -> st.executeUpdate(sql)
            }
            "Было удалено: $value записей."
        }
        else -> "Ошибка."
    }
}

fun main() {
    println(ConnectorForJDBC().execute("SELECT * FROM cities;",
        "select",
        "jdbc:postgresql://127.0.0.1:5432/dreamjob",
        "postgres",
        "password"
    ))
}