package com.sbarrasa.math

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.math.BigInteger

class FibonacciSequenceTest{
    @Test
    fun nEsimo(){
        assertEquals(0, FibonacciSequence.elementAt(0).toInt())
        assertEquals(1, FibonacciSequence.elementAt(1).toInt())
        assertEquals(1, FibonacciSequence.elementAt(2).toInt())
        assertEquals(2, FibonacciSequence.elementAt(3).toInt())
        assertEquals(3, FibonacciSequence.elementAt(4).toInt())
        assertEquals(5, FibonacciSequence.elementAt(5).toInt())
        assertEquals(8, FibonacciSequence.elementAt(6).toInt())
        assertEquals(BigInteger("354224848179261915075"), FibonacciSequence.elementAt(100))

    }
}