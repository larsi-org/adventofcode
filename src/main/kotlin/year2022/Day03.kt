package year2022

import util.asResourceFile

object Day03 {
    private fun priority(c: Char): Int = when (c) {
        in 'a'..'z' ->  1 + c.code - 'a'.code
        in 'A'..'Z' -> 27 + c.code - 'A'.code
        else -> 0
    }

    fun part1(input: List<String>): Int {
        val priorities = mutableListOf<Int>()

        for (line in input) {
            val (a, b) = line.chunked(line.length / 2)
            priorities.add(priority(a.toSet().intersect(b.toSet()).first()))
        }
        println(priorities)

        return priorities.sum()
    }

    fun part2(input: List<String>): Int {
        val priorities = mutableListOf<Int>()

        for (line in input.chunked(3)) {
            val (a, b, c) = line
            priorities.add(priority(a.toSet().intersect(b.toSet().intersect(c.toSet())).first()))
        }
        println(priorities)

        return priorities.sum()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val input = "/year2022/Day03.txt".asResourceFile().readLines()
        println(part1(input))
        println(part2(input))
    }
}
