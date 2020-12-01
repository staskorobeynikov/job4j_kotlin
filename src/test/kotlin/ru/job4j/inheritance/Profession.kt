package ru.job4j.inheritance

open class Profession(val name: String, val surname: String, val education: String)

open class Engineer(
    val category: String,
    name: String,
    surname: String,
    education: String) : Profession(name, surname, education)

class Builder(
    category: String,
    name: String,
    surname: String,
    education: String) : Engineer(category, name, surname, education)

open class Doctor(
    val speciality: String,
    name: String,
    surname: String,
    education: String) : Profession(name, surname, education)

class Surgeon(
    speciality: String,
    name: String,
    surname: String,
    education: String) : Doctor(speciality, name, surname, education)

fun main() {
    val surgeon = Surgeon("neuro", "Tom", "Scott", "High")
    println(surgeon.name + " " + surgeon.surname)

    val doctor = Doctor("neuro", "Tom", "Scott", "High")
    println(doctor.speciality + " " + doctor.name + " " + doctor.surname)

    val builder = Builder("first", "Billy", "Bean", "High")
    println(builder.name + " " + builder.surname)

    val engineer = Engineer("first", "Billy", "Bean", "High")
    println(engineer.category + " " + engineer.name + " " + engineer.surname)
}
