package org.badgrades.euler

object `5SmallestMultiple` {
    
    val divisibleSequence = (1..20).asSequence()
    val divisees = (20..Int.MAX_VALUE) // That is definitely not the name for this kind of thing
    
    @JvmStatic
    fun main(args: Array<String>) {
        val smallestMultiple = divisees.filter { value -> divisibleSequence.all { value % it == 0 } }
                .sorted()
                .first()
        
        println(smallestMultiple)
    }
}