package org.badgrades.euler

import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

/**
 * The following iterative sequence is defined for the set of positive integers:
 *
 * n → n/2 (n is even)
 * n → 3n + 1 (n is odd)
 *
 * Using the rule above and starting with 13, we generate the following sequence:
 * 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
 * It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
 *
 * Which starting number, under one million, produces the longest chain?
 */
object `14LongestCollatzSequence` {

    val sequenceLengths = mutableMapOf<Long, Long>()
    val startingTime = LocalDateTime.now()

    @JvmStatic
    fun main(args: Array<String>) {
        (2L..1_000_000L).forEach { startingNumber ->
            // Generate the sequence until we hit 1 or run into a number that exists in our length dictionary
            collatz(startingNumber)
                    .takeWhileInclusive { sequenceLengths[it] == null }
                    .apply {
                        if (this.count() > 0) {
                            val totalSize = this.count() + (sequenceLengths[this.last()] ?: 0)
                            sequenceLengths[startingNumber] = totalSize
                        }
                    }
        }

        val maxPair = sequenceLengths.maxBy { it.value }
        val runTime = ChronoUnit.MILLIS.between(startingTime, LocalDateTime.now())
        println("The longest number is ${maxPair?.key} with a length of ${maxPair?.value}")
        println("This completed in $runTime milliseconds")
    }

    fun collatz(starting: Long) : Sequence<Long> = generateSequence(
            seed = starting,
            nextFunction = {
                if (it == 1L) null
                else if (it % 2L == 0L) it / 2L
                else it * 3L + 1L
            }
    )

    /*
     * https://gist.github.com/matklad/54776705250e3b375618f59a8247a237
     */
    fun <T> Sequence<T>.takeWhileInclusive(pred: (T) -> Boolean): Sequence<T> {
        var shouldContinue = true
        return takeWhile {
            val result = shouldContinue
            shouldContinue = pred(it)
            result
        }
    }
}