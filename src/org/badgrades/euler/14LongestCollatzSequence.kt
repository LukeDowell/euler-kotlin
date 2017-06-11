package org.badgrades.euler

object `14LongestCollatzSequence` {
    
    @JvmStatic
    fun main(args: Array<String>) {
        println((1_000_000 downTo 1).map {
            println("Generating sequence for $it")
            genCollatzSequence(it)
        }
        .sortedByDescending {
            println("Counted members for starting number: ${it.first()}")
            it.count()
        }
        .first() // First (longest) sequence
        .first()) // First (starting number) in that sequence
    }
    
    fun genCollatzSequence(startingNumber: Int) : Sequence<Int> =
            generateSequence(seed = startingNumber, nextFunction = { n ->
            if (n % 2 == 0) n / 2
            else if (n == 1) null
            else (3 * n) + 1 })
}