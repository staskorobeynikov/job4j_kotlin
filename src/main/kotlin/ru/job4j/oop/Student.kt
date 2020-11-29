package ru.job4j.oop

class Student {
    private var name: String = ""
    private var surname: String = ""
    private var phone: String = ""
    private  var email: String = ""

    constructor(name: String) {
        this.name = name
    }

    constructor(name: String, surname: String) {
        this.name = name
        this.surname = surname
    }

    constructor(name: String, surname: String, phone: String) {
        this.name = name
        this.surname = surname
        this.phone = phone
    }

    constructor(name: String, surname: String, phone: String, email: String) {
        this.name = name
        this.surname = surname
        this.phone = phone
        this.email = email
    }

    fun show() {
        println("$name $surname $phone $email")
    }
}

fun main() {
    var st = Student("name1")
    st.show()
    st = Student("name1", "surname1")
    st.show()
    st = Student("name1", "surname1", "phone1")
    st.show()
    st = Student("name1", "surname1", "phone1", "email1")
    st.show()
}
