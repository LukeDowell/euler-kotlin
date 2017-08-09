package org.badgrades.euler

/**
 * If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 *
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?
 *
 *
 * NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115
 * (one hundred and fifteen) contains 20 letters. The use of "and" when writing out numbers is in compliance with British usage.
 */
object `17NumberLetterCounts` {

    /**
     * Map of numbers pointing to a pair containing the english values of their
     * ones and tens places.
     */
    val dictionary = hashMapOf(
            1 to Pair("one", "ten"),
            2 to Pair("two", "twenty"),
            3 to Pair("three", "thirty"),
            4 to Pair("four", "forty"),
            5 to Pair("five", "fifty"),
            6 to Pair("six", "sixty"),
            7 to Pair("seven", "seventy"),
            8 to Pair("eight", "eighty"),
            9 to Pair("nine", "ninety")
    )

    @JvmStatic
    fun main(args: String) {
        (1..1000).map { convertNumberToWord(it) } // Convert to a word
                .map { it.replace(Regex("[\\s-]+"), "") } // Remove spaces and hypens
                .map { it.length } // Count the length of each word
                .sum() // Sum the length of all number words
                .apply { "The answer to problem 17 is $this" } // Spit that shit out
    }

    fun convertNumberToWord(num: Int) : String {
        // Find out how many decimal places there are in the number
        // Build the number from
        return ""
    }
}