package org.badgrades.euler

object `12HighlyDivisibleTriangularNumber` {
    
    @JvmStatic
    fun main(args: Array<String>) {
        val triangle = generateSequence(seed = Pair(1L, 1L), nextFunction = { (_, index) -> Pair(getTriangleNumber(index), index + 1L)})
        val list = triangle.take(100_000).toList()
        
        list.first { getFactorsForNumber(it.first).size > 500 }
    }
    
    fun getTriangleNumber(index: Long) : Long = (0..index).sum()
    fun getFactorsForNumber(number: Long) : List<Long> = (number..1).filter { number % it == 0L }.toList()
}