package year2021

import util.asResourceFile

object Day01 {
    fun part1(input: List<Int>): Int {
        return input.windowed(2).count { (a, b) -> a < b }
    }

    fun part2(input: List<Int>): Int {
        return part1(input.windowed(3).map { (a, b, c, ) -> a + b + c })
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val input = "/year2021/Day01.txt".asResourceFile().readLines().map { it.toInt()}
        println(part1(input))
        println(part2(input))
    }
}