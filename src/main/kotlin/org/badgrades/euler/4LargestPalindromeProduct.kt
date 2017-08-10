package org.badgrades.euler

object `4LargestPalindromeProduct` {
    
    @JvmStatic
    fun main(args: Array<String>) {
        var highestPalindrome = 0
        for (i in (100..999)) {
            (100..999)
                    .asSequence()
                    .filter { isNumberPalindrome(i * it) && highestPalindrome < i * it }
                    .forEach { highestPalindrome = i * it }
        }
        
        println(highestPalindrome)
    }
    
    fun isNumberPalindrome(number: Int) : Boolean {
        val numString = number.toString()
        return numString.chars().toArray()
                .filterIndexed { index, _ -> numString[index] != numString[numString.length - 1 - index] }
                .none()
    }
}