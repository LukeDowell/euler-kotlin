package org.badgrades.euler

import java.math.BigInteger

object `3LargestPrimeFactor` {
    
    val targetNumber: BigInteger = BigInteger("600851475143")
    
    @JvmStatic
    fun main(args: Array<String>) {
        println(largestPrimeFactorForNumber(targetNumber))
    }
    
    fun largestPrimeFactorForNumber(input: BigInteger) : BigInteger {
        var i: BigInteger = BigInteger("2")
        var number = input
        
        while (i <= number) {
            if (number.mod(i) == BigInteger.ZERO) {
                number = number.div(i)
                i = i.minus(BigInteger.ONE)
            }
            
            i = i.plus(BigInteger.ONE)
        }
        
        return i
    }
}
