package org.badgrades.euler

import java.io.File
import java.util.*

object `8LargestProductInASeries` {
    
    val input: String = Scanner(File("res/problem8input.txt")).next()
    val size = 13
    
    @JvmStatic
    fun main(args: Array<String>) {
        val answer = (0..input.length - size)
                .map { calcAdjacent(index = it) }
                .sortedDescending()
        
        
        println(answer)
    }
    
    fun calcAdjacent(string: String = input, index: Int, adjacentNumbers: Int = size) : Int {
        return (index..index + adjacentNumbers)
                .map {
                    try {
                        Integer.parseInt(string[it].toString())
                    } catch (e: StringIndexOutOfBoundsException) {
                        1
                    }
                }
                .reduce { a, b -> a * b }
    }
}