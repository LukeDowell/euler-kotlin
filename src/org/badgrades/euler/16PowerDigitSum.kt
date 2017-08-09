package org.badgrades.euler

import java.math.BigInteger

/**
 * 215 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 *
 * What is the sum of the digits of the number 21000?
 */
object `16PowerDigitSum` {

    @JvmStatic
    fun main(args: Array<String>) {
        BigInteger("2").pow(1000)
                .toString()
                .map { Integer.parseInt(it.toString()) }
                .sum()
                .apply { println("The answer to problem 16 is $this") }
    }
}