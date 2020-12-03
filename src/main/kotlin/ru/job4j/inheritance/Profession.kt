package ru.job4j.inheritance

open class Profession(val name: String, val surname: String, val education: String) {
    open fun getName() {
        println(name)
    }

    open fun action() {
        println("execute some actions")
    }
}

open class Engineer(
    val category: String,
    name: String,
    surname: String,
    education: String) : Profession(name, surname, education) {

    override fun getName() {
        super.getName()
        println(name)
    }

    override fun action() {
        super.action()
        println("action from Engineer")
    }
}

class Builder(
    category: String,
    name: String,
    surname: String,
    education: String) : Engineer(category, name, surname, education) {

    override fun getName() {
        super.getName()
        println(name)
    }

    override fun action() {
        super.action()
        println("action from Builder")
    }
}

open class Doctor(
    val speciality: String,
    name: String,
    surname: String,
    education: String) : Profession(name, surname, education) {

    override fun getName() {
        super.getName()
        println(name)
    }

    override fun action() {
        super.action()
        println("action from Doctor")
    }
}

class Surgeon(
    speciality: String,
    name: String,
    surname: String,
    education: String) : Doctor(speciality, name, surname, education) {

    override fun getName() {
        super.getName()
        println(name)
    }

    override fun action() {
        super.action()
        println("action from Surgeon")
    }
}

fun main() {
    val surgeon = Surgeon("neuro", "Tom", "Scott", "High")
    println(surgeon.name + " " + surgeon.surname)
    println()
    val doctor = Doctor("neuro", "Tom", "Scott", "High")
    println(doctor.speciality + " " + doctor.name + " " + doctor.surname)
    println()
    val builder = Builder("first", "Billy", "Bean", "High")
    println(builder.name + " " + builder.surname)
    println()
    val engineer = Engineer("first", "Billy", "Bean", "High")
    println(engineer.category + " " + engineer.name + " " + engineer.surname)
    println()
    val professions: Array<Profession> = arrayOf(
        surgeon,
        doctor,
        builder,
        engineer
    )
    for (profession in professions) {
        profession.getName()
        profession.action()
        println()
    }
}
