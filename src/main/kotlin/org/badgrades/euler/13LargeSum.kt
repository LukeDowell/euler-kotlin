package org.badgrades.euler

import java.io.File
import java.math.BigInteger
import java.util.*

object `13LargeSum` {
    
    @JvmStatic
    fun main(args: Array<String>) {
        val scanner = Scanner(File("res/problem13input.txt"))
        val listOfNumbers: MutableList<BigInteger> = mutableListOf()
        
        while (scanner.hasNext()) {
            listOfNumbers.add(BigInteger(scanner.next()))
        }
        
        val sum = listOfNumbers.reduce { acc, bigInteger -> acc.plus(bigInteger) }
        val firstTenDigits = sum.toString().subSequence(0, 10)
        println(firstTenDigits)
    }
}