package com.sbarrasa.util

class Name {
    private val list = ArrayList<String>()

    constructor()

    constructor(first: String, last: String = "") {
        this.first = first
        this.last = last
    }

    constructor(fullName: String) {
        list.addAll(split(fullName))
    }

    private fun split(value: String) = value.trim().split("\\s+".toRegex())

    operator fun get(index: Int): String = list.getOrElse(index - 1) { "" }

    operator fun set(index: Int, value: String) {
        val oneName = getOne(value)

        while (list.size < index) {
            list.add("")
        }
        list[index - 1] = oneName
    }

    private fun getOne(value: String) = split(value).firstOrNull() ?: ""

    var first: String
        get() = get(1)
        set(value) = set(1, value)

    var last: String
        get() = list.takeLast(lastCnt).joinToString(" ")
        set(value) {
            val parts = split(value)
            lastCnt = parts.size
            list.dropLast(lastCnt)
            list.addAll(parts)
        }

    var lastCnt = 1

    val size: Int
        get() = list.size

    fun standardFormat() = "$last, $first"

    fun fullFormat() = list.joinToString(" ")

    override fun toString(): String {
        return fullFormat()
    }
}