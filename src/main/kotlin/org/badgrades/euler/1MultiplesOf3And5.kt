package org.badgrades.euler

object `1MultiplesOf3And5` {
    
    @JvmStatic
    fun main(args: Array<String>) {
        val sumOfMultiples = (0..999)
                .filter { it % 3 == 0 || it % 5 == 0 }
                .sum()
        
        println(sumOfMultiples)
    }
}