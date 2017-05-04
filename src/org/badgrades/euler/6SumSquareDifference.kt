package org.badgrades.euler

object `6SumSquareDifference` {
    
    @JvmStatic
    fun main(args: Array<String>) {
        val firstOneHundredNaturals = (1..100).asSequence()
        val hundredSum = firstOneHundredNaturals.sum()
        val hundredSquareSum = firstOneHundredNaturals
                .map { it * it }
                .sum()
        
        println((hundredSum * hundredSum) - hundredSquareSum)
    }
}