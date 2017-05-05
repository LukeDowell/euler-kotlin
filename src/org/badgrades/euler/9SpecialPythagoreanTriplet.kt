package org.badgrades.euler

object `9SpecialPythagoreanTriple` {
    
    @JvmStatic
    fun main(args: Array<String>) {
        val triples = mutableListOf<Triple<Int, Int, Int>>()
        
        for (a in (0..999)) {
            for (b in (0..999)) {
                for (c in (0..999)) {
                    if ((a * a) + (b * b) == (c * c)
                            && a < b
                            && b < c) {
                        val triple = Triple(a, b, c)
                        println("Triple found $triple")
                        triples.add(triple)
                    }
                }
            }
        }
        
        val special = triples.filter { isSpecialTriple(it) }.first()
        println(special.first * special.second * special.third)
    }
    
    fun isSpecialTriple(triple: Triple<Int, Int, Int>) : Boolean = triple.first + triple.second + triple.third == 1000
}
