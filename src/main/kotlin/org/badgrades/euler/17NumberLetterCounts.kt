package org.badgrades.euler

import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

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

    val startingTime = LocalDateTime.now()

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

    /**
     * Map of teen numbers that just have to be different for no reason
     */
    val teens = hashMapOf(
            10 to "ten",
            11 to "eleven",
            12 to "twelve",
            13 to "thirteen",
            14 to "fourteen",
            15 to "fifteen",
            16 to "sixteen",
            17 to "seventeen",
            18 to "eighteen",
            19 to "nineteen"
    )

    @JvmStatic
    fun main(args: Array<String>) {
        val wordList = (1..1000).map { convertNumberToWord(it) }
        val answer = wordList.map { it.replace(" ", "").replace("-", "") } // Remove hyphens and spaces
                .map { it.length } // Count the length of each word
                .sum() // Sum the length of all number words

        println(wordList)
        println("The answer to problem 17 is $answer")
        println("This completed in ${ChronoUnit.MILLIS.between(startingTime, LocalDateTime.now())} milliseconds")
    }

    fun convertNumberToWord(num: Int) : String {
        val englishNumber = StringBuilder()

        // Turn our number into a backwards array of integers so we can see each decimal individually
        val numArray = num.toString()
                .toCharArray()
                .map { Integer.parseInt(it.toString()) }
                .reversed()

        numArray.forEachIndexed { index, i ->
                    when (index) {
                        // Ones
                        0 -> {
                            // Check to see if the next number is a 1 so we can ignore edge cases
                            if (numArray.size == 1 || (numArray.size > 1 && numArray[1] != 1)) {
                                englishNumber.append(dictionary[i]?.first ?: "")

                                // Add the nice little hyphen to be fancy
                                if (i != 0 && numArray.size > 1) {
                                    englishNumber.insert(0, "-")
                                }
                            }
                        }

                        // Tens
                        1 -> {
                            // Handle weird angsty teen numbers
                            var tens = ""
                            if (i == 1) {
                                tens += teens[10 + numArray[0]] ?: ""
                            } else {
                                tens += dictionary[i]?.second ?: ""
                            }

                            if (numArray.size > 2 && (numArray[0] != 0 || numArray[1] != 0)) {
                                tens = " and " + tens
                            }

                            englishNumber.insert(0, tens)
                        }

                        // Hundreds
                        2 -> {
                            var hundreds = ""
                            if (i != 0) {
                                hundreds = dictionary[i]?.first + " hundred" ?: ""
                            }

                            if (numArray.size > 3 && numArray[0] != 0 && numArray[1] != 0) {
                                hundreds = " and " + hundreds
                            }

                            englishNumber.insert(0, hundreds)
                        }

                        // Thousands
                        3 -> {
                            englishNumber.insert(0, dictionary[i]?.first + " thousand" ?: "")
                        }
                    }
                }

        return englishNumber.toString()
    }
}