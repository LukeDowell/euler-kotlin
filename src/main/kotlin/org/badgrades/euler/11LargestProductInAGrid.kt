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
        
        var highestNumber = 0
        
        grid.gridIndex { x, y, _ -> grid[x][y] = stringInput.nextInt() }
        grid.gridIndex { x, y, _ ->
            val highestProductAtPoint = largestProductAtPoint(x, y, grid)
            if (highestNumber < highestProductAtPoint)
                highestNumber = highestProductAtPoint
        }
        
        println(highestNumber)
    }
    
    fun largestProductAtPoint(x: Int, y: Int, grid: Array<IntArray>) : Int {
        val highestProductForDirections: List<Int> = Direction.values().map { direction ->
            (1..4).map { i ->
                if ((0..grid.size - 1).contains(x + (direction.xOffset * i)) && (0..grid[0].size - 1).contains(y + (direction.yOffset * i))) {
                    grid[x + (direction.xOffset * i)][y + (direction.yOffset * i)]
                } else {
                    1
                }
            }.reduce { acc : Int, i : Int ->
                acc * i
            }
        }
        
        return highestProductForDirections.max() ?: 0
    }
    
    fun Array<IntArray>.gridIndex(operation: (x: Int, y: Int, value: Int) -> Unit) {
        this.forEachIndexed { y, columns ->
            columns.forEachIndexed { x, value ->
                operation(x, y, value)
            }
        }
    }
}

enum class Direction(val xOffset: Int, val yOffset: Int) {
    UP(0, 1),
    DOWN(0, -1),
    LEFT(-1, 0),
    RIGHT(1, 0),
    UPPER_LEFT(-1, 1),
    UPPER_RIGHT(1, 1),
    LOWER_LEFT(-1, -1),
    LOWER_RIGHT(1, -1)
}