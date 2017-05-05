package org.badgrades.euler

import java.io.File
import java.math.BigInteger
import java.util.*

object `8LargestProductInASeries` {
    
    val input: String = Scanner(File("res/problem8input.txt")).next()
    val size = 13
    
    @JvmStatic
    fun main(args: Array<String>) {
        val answer = (0..input.length)
                .map { calcAdjacent(index = it) }
                .sortedDescending()
        
        
        println(answer)
    }
    
    fun calcAdjacent(string: String = input, index: Int, adjacentNumbers: Int = size) : BigInteger {
        return (index..(index + adjacentNumbers - 1))
                .map {
                    try {
                        BigInteger(string[it].toString())
                    } catch (e: StringIndexOutOfBoundsException) {
                        BigInteger.ONE
                    }
                }
                .reduce { a, b -> a.multiply(b) }
    }
}