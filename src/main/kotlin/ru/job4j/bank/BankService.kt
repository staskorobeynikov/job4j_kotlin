package ru.job4j.bank

/**
 * Класс описывает сервис банковских переводов.
 */
class BankService {
    private val users: MutableMap<User, MutableList<Account>> = mutableMapOf()

    /**
     * Метод добавляет [user] в карту и ассоциированный с ним пустой список аккаунтов.
     */
    fun addUser(user: User) {
        users.putIfAbsent(user, mutableListOf())
    }

    /**
     * Метод добавляет [account] в список аккаунтов пользователя, у которого совпал [passport].
     */
    fun addAccount(passport: String, account: Account) {
        findByPassport(passport)?.let {
            user -> users[user]?.add(account)
        }
    }

    /**
     * Метод поиска пользователя по [passport]
     * @return пользователь, у которого паспортные данные равны переданному параметру [passport].
     */
    fun findByPassport(passport: String): User? {
        return users.keys.find { it.passport == passport }
    }

    /**
     * Метод ищет аккаунт по [passport] и [requisite]
     * @return аккаунт, у которого совпали паспортные данные и реквизиты аккаунта.
     */
    fun findByRequisite(passport: String, requisite: String): Account? {
        return findByPassport(passport)?.let {
            user -> users[user]?.find { it -> it.requisite == requisite }
        }
    }

    /**
     * Метод осуществляет перевод с аккаунта с данными: паспорт - [srcPassport], реквизиты - [srcRequisite]
     * на аккаунт с данными: паспорт - [destPassport], реквизиты - [destRequisite].
     * @return true когда перевод был осуществлен, или false в следующих случаях:
     * 1. Аккаунт, с которого осущетвляется перевод не существует;
     * 2. Баланс аккаунта, с которого осуществляется перевод, меньше суммы [amount];
     * 3. Аккаунт на который осуществляется перевод не существует.
     */
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
