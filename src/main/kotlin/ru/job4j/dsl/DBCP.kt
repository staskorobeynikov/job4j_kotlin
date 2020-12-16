package ru.job4j.dsl

import org.apache.commons.dbcp2.BasicDataSource

class DBCP private constructor(
    private val driverClassName: String,
    private val url: String,
    private val username: String,
    private val password: String,
    private val maxIdle: Int,
    private val minIdle: Int,
    private val maxOpenPreparedStatements: Int) {

    fun pool(): BasicDataSource {
        val pool = BasicDataSource()
        pool.driverClassName = driverClassName
        pool.url = url
        pool.username = username
        pool.password = password
        pool.maxIdle = maxIdle
        pool.minIdle = minIdle
        pool.maxOpenPreparedStatements = maxOpenPreparedStatements
        return pool
    }

    companion object Builder {
        private var driverClassName: String? = null
        private var url: String? = null
        private var username: String? = null
        private var password: String? = null
        private var maxIdle: Int = 8
        private var minIdle: Int = 0
        private var maxOpenPreparedStatements: Int = Integer.MAX_VALUE

        fun driverClassName(name: String) = apply { driverClassName = name }

        fun url(u: String) = apply { url = u }

        fun username(name: String) = apply { username = name }

        fun password(p: String) = apply { password = p }

        fun maxIdle(i: Int) = apply { maxIdle = i }

        fun minIdle(i: Int) = apply { minIdle = i }

        fun maxOpenPreparedStatements(i: Int) = apply { maxOpenPreparedStatements = i }

        fun build() : DBCP = DBCP(
            driverClassName ?: " ",
            url ?: " ",
            username ?: " ",
            password ?: " ",
            maxIdle, minIdle, maxOpenPreparedStatements
        )
    }
}

fun main() {
    val dbcp = DBCP
        .driverClassName("org.postgresql.Driver")
        .url("jdbc:postgresql://127.0.0.1:5432/dreamjob")
        .username("postgres")
        .password("password")
        .maxIdle(10)
        .minIdle(5)
        .maxOpenPreparedStatements(100)
        .build()

    val pool = dbcp.pool()

    val rsl = mutableListOf<City>()
    val connection = pool.getConnection()
    val ps = connection.prepareStatement("SELECT * FROM cities;")
    val query = ps.executeQuery()
    while (query.next()) {
        rsl.add(City(query.getInt("id"), query.getString("city")))
    }
    query.close()
    ps.close()
    for (i in 0 until rsl.size) {
        println(rsl.get(i).name)
    }
}
