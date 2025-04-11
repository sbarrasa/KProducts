package com.sbarrasa.util

class Name {
    val names = ArrayList<String>()
    val lastNames = ArrayList<String>()

    constructor()

    constructor(names: String, lastNames: String = "") {
        this.names.addAll(split(names))
        this.lastNames.addAll(split(lastNames))
    }

    constructor(fullName: String) {
        val parts = split(fullName)
        if (parts.isNotEmpty()) {
            lastNames.add(parts.last())
            names.addAll(parts.dropLast(1))
        }
    }

    private fun split(value: String) = value.trim().split("\\s+".toRegex())

    val first: String
        get() = names.get(0)

    val last: String
        get() = lastNames.joinToString(" ")


    val size: Int
        get() = names.size + lastNames.size

    operator fun get(index: Int) = fullName().get(index-1)

    fun fullName() = names + lastNames

    fun standardFormat() = "$last, $first"

    fun lastNamesFormat() = lastNames.joinToString(" ")

    fun onlyNamesFormat() = names.joinToString(" ")

    fun fullNameFormat() = "${onlyNamesFormat()} ${lastNamesFormat()}"


    override fun toString(): String {
        return fullNameFormat()
    }
}