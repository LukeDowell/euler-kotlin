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


        println("This completed in ${ChronoUnit.MILLIS.between(startingTime, LocalDateTime.now())} milliseconds")
    }
}