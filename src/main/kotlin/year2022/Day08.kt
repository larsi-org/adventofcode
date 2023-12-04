package year2022

import util.asResourceFile

object Day08 {
    fun part1(grid: Array<IntArray>): Int {
        return 0
    }

    fun part2(input: Array<IntArray>): Int {
        return 0
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val input = "/year2022/Day08sm.txt".asResourceFile().readLines()
        val xDim = input[0].length
        val yDim = input.size
        val grid = Array(yDim) { IntArray(xDim) }
        for ((yIdx, rowVal) in input.withIndex()) {

        }
        println(grid)
        println(part1(grid))
        println(part2(grid))
    }
}
