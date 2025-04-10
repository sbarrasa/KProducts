package com.sbarrasa.util

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class NameTest {
    @Test
    fun getFirstLast() {
        val name = Name(first = "Juan", last = "Perez")
        assertEquals("Juan", name.first)
        assertEquals("Perez", name.last)

    }

    @Test
    fun add() {
        val name = Name()
        name[1] = "Juan"
        name[3] = "Perez"

        assertEquals("Juan", name.first)
        assertEquals("Perez", name.last)
    }

    @Test
    fun first() {
        val name = Name()
        name.first = "Juan"
        assertEquals("Juan", name.first)
    }

    @Test
    fun get() {
        val name = Name("Juan Carlos Perez")
        assertEquals("Juan", name[1])
        assertEquals("Carlos", name[2])
    }


    @Test
    fun toStringTest() {
        val name = Name("Juan Carlos Perez")
        assertEquals("Juan Carlos Perez", name.toString())
    }

    @Test
    fun formattedStandard() {
        val name = Name("Juan Carlos Perez")
        assertEquals("Perez, Juan", name.standardFormat())
        assertEquals("Perez, Juan", name.formatted())
    }

    @Test
    fun getFullName() {
        val name = Name("Juan Carlos Perez")
        assertEquals("Juan Carlos Perez", name.fullFormat())
    }

    @Test
    fun formated(){
        val name = Name("Juan Carlos Perez")
        assertEquals("Carlos Perez", name.formatted("${name[2]} ${name[3]}"))

    }

    @Test
    fun doubleLastName(){
        val name = Name(first= "Juan", last = "Perez García")
        assertEquals("Juan", name.first)
        assertEquals("Perez García", name.last)
        assertEquals(2, name.lastCnt)
        name.lastCnt = 1
        assertEquals("García", name.last)
    }

    @Test
    fun one() {
        val  name = Name( first = "Juan Carlos", last= "Perez")
        assertEquals("Juan", name.first)
        assertEquals(2, name.size)
    }

    @Test
    fun noLast(){
        val  name = Name( first = "Juan")
        assertEquals("", name.last)
    }

    @Test
    fun nNames(){
        val name = Name()
        name[1] = "Juan"
        name[3] = "Gabriel"
        name[8] = "Otro"

        assertEquals(8, name.size)
    }

    @Test
    fun interpolation(){
        val name = Name(first = "Juan", last = "Perez Lopez")
        assertEquals("Juan Perez Lopez", "$name")
    }


}