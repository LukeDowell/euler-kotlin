package org.badgrades.euler

import java.math.BigInteger

object `2EvenFibonacciNumbers` {
    
    @JvmStatic
    fun main(args: Array<String>) {
        var n = 1
        
        // Figure out the correct length of the fibonacci sequence
        do {
            val fibSum = sumBigIntegerSequence(fibonacci().take(n++))
        } while (fibSum <= BigInteger("4000000"))
        
        // Create the final sequence and filter out odd numbers
        val finalSequence = fibonacci().take(n).filter { it.mod(BigInteger("2")) == BigInteger.ZERO }
        
        println(sumBigIntegerSequence(finalSequence))
    }
    
    fun sumBigIntegerSequence(sequence: Sequence<BigInteger>) : BigInteger {
        return sequence.foldIndexed(
                initial = sequence.first(),
                operation = { index, acc, value ->
                    if (index != 0) {
                        acc.plus(value)
                    } else {
                        acc
                    }
                }
        )
    }
    
    fun fibonacci(): Sequence<BigInteger> {
        return generateSequence(
                seed = Pair(BigInteger.ZERO, BigInteger.ONE),
                nextFunction = { Pair(it.second, it.first + it.second) }
                ).map { it.first }
    }
}
