package org.badgrades.euler

object `12HighlyDivisibleTriangularNumber` {
    
    @JvmStatic
    fun main(args: Array<String>) {
        val triangle = generateSequence(
                seed = Pair(1L, 1L),
                nextFunction = { Pair(getTriangleNumber(it.second + 1L), it.second + 1L) }
        )
        val list = triangle.take(100_000).toList()

        println(list.first { getFactorsForNumber(it.first).size > 500 }.first)
    }
    
    fun getTriangleNumber(index: Long) : Long = (0..index).sum()

    fun getFactorsForNumber(number: Long) : List<Long> {
        val factors = mutableListOf<Long>()
        val numberSqrt = Math.ceil(Math.sqrt(number.toDouble())).toLong()
        (1L..numberSqrt).forEach {
            if (number % it == 0L) {
                factors.add(it)
                factors.add(number / it)
            }
        }
        return factors.distinct()
    }
}