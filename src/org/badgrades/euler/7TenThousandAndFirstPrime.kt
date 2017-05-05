package org.badgrades.euler

object `7TenThousandAndFirstPrime` {
    
    @JvmStatic
    fun main(args: Array<String>) {
        val intList = generateSequence(seed = Pair(2, true), nextFunction = { (first, second) -> Pair(first + 1, second) })
                .take(1_000_000)
                .toMutableList()
        
        val primes = sieveOfEratosthenes(list = intList)
        
        println(primes[10_000])
     }
    
    /**
     *
     * @param primeIndex The number by which we iterate through the set, toggling numbers as we go
     * @param list A list of pairs, with a pair being a natural number and boolean. The boolean is to keep
     * track of whether or not the number is 'marked'
     */
    tailrec fun sieveOfEratosthenes(prime: Int = 2, list: MutableList<Pair<Int, Boolean>>) : List<Int> {
        // Iterate and mark all multiples of p
        val startingIndex = list.indexOfFirst { it.first == prime }
        (startingIndex..list.size - 1 step prime)
                .filter { list[it].first != prime }
                .forEach { list[it] = Pair(list[it].first, false) }
        
        // Find the next prime greater than p
        val nextPrime: Int? = list.firstOrNull { it.first > prime && it.second }?.first
        
        // Return if the value is null or if nextPrime squared is greater than the biggest number in the list
        if (nextPrime == null || (nextPrime * nextPrime) > list[list.size - 1].first) {
            return list.filter { it.second }
                    .map { it.first }
        }
        
        return sieveOfEratosthenes(nextPrime, list)
    }
}