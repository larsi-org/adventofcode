package year2021

import util.asResourceFile

enum class Direction {
    UP, DOWN, FORWARD
}

data class Step(val direction: Direction, val units: Int)

fun String.toStep() = Step(
    Direction.valueOf(substringBefore(" ").uppercase()),
    substringAfter(" ").toInt()
)

object Day02 {
    fun part1(input: List<String>): Int {
        var x = 0
        var y = 0
        for (l in input) {
            val s = l.toStep()
            when (s.direction) {
                Direction.UP -> y -= s.units
                Direction.DOWN -> y += s.units
                Direction.FORWARD -> x += s.units
            }
        }
        return x * y
    }

    fun part2(input: List<String>): Int {
        var x = 0
        var y = 0
        var aim = 0
        for (l in input) {
            val s = l.toStep()
            when (s.direction) {
                Direction.UP -> aim -= s.units
                Direction.DOWN -> aim += s.units
                Direction.FORWARD -> { x += s.units; y += s.units * aim }
            }
        }
        return x * y
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val input = "/year2021/Day02.txt".asResourceFile().readLines()
        println(part1(input))
        println(part2(input))
    }
}
