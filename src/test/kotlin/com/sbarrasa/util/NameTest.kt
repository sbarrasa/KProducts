package com.sbarrasa.util

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class NameTest {
    @Test
    fun getFirstLast() {
        val name = Name(names = "Juan Carlos", lastNames = "Perez Gomez")
        assertEquals("Juan", name.first)
        assertEquals("Perez Gomez", name.last)

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
    }

    @Test
    fun fullNameFormat() {
        val name = Name("Juan Carlos Perez")
        assertEquals("Juan Carlos Perez", name.fullNameFormat())
    }

    @Test
    fun formated(){
        val name = Name("Juan Carlos Perez")
        assertEquals("Carlos Perez", "${name[2]} ${name[3]}")

    }

    @Test
    fun onlyNamesFormat(){
        val name = Name("Juan Carlos Perez")
        assertEquals("Juan Carlos", name.onlyNamesFormat())
    }

    @Test
    fun lasteNamesFormat(){
        val name = Name("Juan Carlos Perez")
        assertEquals("Perez", name.lastNamesFormat())

        val name2 = Name(names = "Juan Carlos", lastNames = "Perez Lopez")
        assertEquals("Perez Lopez", name2.lastNamesFormat())


    }


    @Test
    fun doubleLastName(){
        val name = Name(names = "Juan Carlos", lastNames = "Perez García")
        assertEquals("Juan", name.first)
        assertEquals("Perez García", name.last)
    }

    @Test
    fun firstAndLast() {
        val  name = Name( names = "Juan Carlos", lastNames = "Perez")
        assertEquals("Juan", name.first)
        assertEquals(3, name.size)
    }

    @Test
    fun noLast(){
        val  name = Name( names = "Juan")
        assertEquals("", name.last)
    }


    @Test
    fun interpolation(){
        val name = Name(names = "Juan", lastNames = "Perez Lopez")
        assertEquals("Juan Perez Lopez", "$name")
    }


}