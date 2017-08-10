package org.badgrades.euler

import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

/**
 * Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, there are exactly 6 routes to the bottom right corner.
 */
object `15LatticePaths` {

    val startingTime = LocalDateTime.now()

    @JvmStatic
    fun main(args: Array<String>) {
        println("The answer to problem 15 is ${binomialCoefficient(40L, 20L)}")
        println("This completed in ${ChronoUnit.MILLIS.between(startingTime, LocalDateTime.now())} milliseconds")
    }

    /** https://rosettacode.org/wiki/Evaluate_binomial_coefficients#Java */
    fun binomialCoefficient(n: Long, k: Long) : Long {
        var n2 = n
        var k2 = k

        if (k > n - k)
            k2 = n - k

        var b = 1L
        var i = 1
        var m = n
        while (i <= k2) {
            b = b * m / i
            i++
            m--
        }

        return b
    }
}