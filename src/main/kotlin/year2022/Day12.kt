package year2022

import util.asResourceFile

object Day12 {
    val input = "/year2022/Day12sm.txt".asResourceFile().readLines()

    fun parse(input: List<String>): Grid = input.map { line ->
        line.map { char ->
            when (char) {
                'S' -> 0
                'E' -> 'z'.code - 'a'.code
                else -> char.code - 'a'.code
            }
        }.toIntArray()
    }.toTypedArray()

    fun findChar(input: List<String>, char: Char): Coordinate = input.mapIndexed { y, row ->
        val x = row.indexOf(char)
        x to y
    }.single { it.first != -1 }

    fun isValid(grid: Grid, dim: Coordinate, start: Coordinate, dest: Coordinate) =
        dest.first >= 0 && dest.second >= 0 &&
        dest.first < dim.first && dest.second < dim.second &&
        grid[dest] <= grid[start] + 1


    fun part1(grid: Grid, dim: Coordinate, start: Coordinate, end: Coordinate): Int {
        return 0
    }

    fun part2(input: List<String>): Int {
        return 0
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val grid = parse(input)
        val dim = Coordinate(input.first().length, input.size)
        val start = findChar(input, 'S')
        val end = findChar(input, 'E')

        println("""
            $grid
            $dim
            $start -> $end
        """.trimIndent())

        println(part1(grid, dim, start, end))
        println(part2(input))
    }
}

typealias Grid = Array<IntArray>
typealias Coordinate = Pair<Int,Int>

operator fun Grid.get(location: Coordinate): Int = this[location.second][location.first]
operator fun Grid.set(location: Coordinate, value: Int) {
    this[location.second][location.first] = value
}

enum class Direction(val dX: Int, val dY: Int) {
    LEFT(-1, 0),
    RIGHT(1, 0),
    UP(0, -1),
    DOWN(0, 1)
}
