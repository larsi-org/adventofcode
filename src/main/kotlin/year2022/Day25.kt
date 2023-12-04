package year2022

import util.asResourceFile

object Day25 {
    fun snafuToBase5(s: String) = s.map {
        when (it) {
            '=' -> -2
            '-' -> -1
            '0' -> 0
            '1' -> 1
            '2' -> 2
            else -> 0
        }
    }

    fun base5ToLong(b5: List<Int>) = b5.fold(0L) { total, item -> item + 5 * total}

    fun intToBase5(i: Long) = i.toString(5).map { it.code - '0'.code }

    fun base5ToSnafu(b5: List<Int>): String {
        val b5new = b5.reversed().toMutableList()
        b5new.forEachIndexed { index, value ->
            if (value > 2) {
                b5new[index] = value - 5
                b5new[index + 1] = b5new[index + 1] + 1
            }
        }
        return b5new.reversed().map { "=-012".get(2 + it) }.joinToString("")
    }

    fun part1(input: List<String>): String {
        val s = input.sumOf { base5ToLong(snafuToBase5(it)) }
        return base5ToSnafu(intToBase5(s))
    }

    fun part2(input: List<String>): String {
        return ""
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val input = "/year2022/Day25.txt".asResourceFile().readLines()
        println(part1(input))
        println(part2(input))
    }
}
