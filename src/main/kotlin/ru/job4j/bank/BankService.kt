package ru.job4j.bank

class BankService {
    private val users: MutableMap<User, MutableList<Account>> = mutableMapOf()

    fun addUser(user: User) {
        users.putIfAbsent(user, mutableListOf())
    }

    fun addAccount(passport: String, account: Account) {
        val user = findByPassport(passport) ?: return
        users[user]?.add(account)
    }

    fun findByPassport(passport: String): User? {
        return users.keys.find { it.passport == passport }
    }

    fun findByRequisite(passport: String, requisite: String): Account? {
        val user = findByPassport(passport) ?: return null
        return users[user]?.find { it -> it.requisite == requisite }
    }

    fun transferMoney(srcPassport: String, srcRequisite: String,
                      destPassport: String, destRequisite: String, amount: Double): Boolean {
        val srcAccount = findByRequisite(srcPassport, srcRequisite)
        val destAccount = findByRequisite(destPassport, destRequisite)
        if (srcAccount != null && destAccount != null && srcAccount.balance >= amount) {
            srcAccount.balance = srcAccount.balance.minus(amount)
            destAccount.balance = destAccount.balance.plus(amount)
            return true
        }
        return false
    }
}

fun main() {
    val bank = BankService()
    bank.addUser(User("321", "Petr Arsentev"))
    val byPassport = bank.findByPassport("3211")
    println(byPassport)
    val user = bank.findByPassport("321")
    println(user)
    bank.addAccount("321", Account("1111", 250.0))
    bank.addAccount("321", Account("2222", 350.0))
    bank.transferMoney("321", "1111", "321", "2222", 175.0)
    println(bank.findByRequisite("321", "1111"))
    println(bank.findByRequisite("321", "2222"))
    bank.transferMoney("321", "1111", "321", "2222", 500.0)
    println(bank.findByRequisite("321", "1111"))
    println(bank.findByRequisite("321", "2222"))
}
