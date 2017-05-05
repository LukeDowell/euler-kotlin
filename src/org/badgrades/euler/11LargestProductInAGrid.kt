package org.badgrades.euler

import java.io.File
import java.util.*

object `11LargestProductInAGrid` {
    
    val gridHeight = 20
    val gridWidth = 20
    val stringInput = Scanner(File("res/problem11input.txt"))
    
    @JvmStatic
    fun main(args: Array<String>) {
        val grid = Array(gridHeight, { IntArray(gridWidth) })
        
        grid.gridIndexed { x, y, _ -> grid[x][y] = stringInput.nextInt() }
        grid.gridIndexed { x, y, value -> println("X: $x Y: $y Val: $value") }
    }
    
    fun Array<IntArray>.gridIndexed(operation: (x: Int, y: Int, value: Int) -> Unit) {
        this.forEachIndexed { y, columns ->
            columns.forEachIndexed { x, value ->
                operation(x, y, value)
            }
        }
    }
}