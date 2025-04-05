package com.sbarrasa.math

import java.math.BigInteger

object FibonacciSequence : Sequence<BigInteger> {
    override fun iterator() = object : Iterator<BigInteger> {
        var pair = Pair(BigInteger.ZERO, BigInteger.ONE)

        override fun hasNext() = true

        override fun next(): BigInteger {
            val result = pair.first
            pair = Pair(pair.second, pair.first + pair.second)
            return result
        }
    }
}