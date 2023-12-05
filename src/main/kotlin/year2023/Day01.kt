package year2023

import util.asResourceFile

object Day01 {
    private val digits = listOf("one", "two", "three", "four", "five", "six", "seven", "eight", "nine")
    private val digitsR = digits.map { d -> d.reversed() }

    private fun findFirstDigit(st: String, digits: List<String>): Char {
        var x = st
        var whichDigit = -1
        var minPos = Int.MAX_VALUE
        digits.forEachIndexed { idx, s ->
            val pos = x.indexOf(s)
            if (pos in 0 until minPos) {
                minPos = pos
                whichDigit = idx
            }
        }
        if (whichDigit >= 0) x = x.replaceFirst(digits[whichDigit], (1 + whichDigit).toString())
        return x.first { c -> c.isDigit() }
    }

    private fun findNumber(st: String): Int {
        val xFirst = findFirstDigit(st, digits)
        val xLast = findFirstDigit(st.reversed(), digitsR)
        return "$xFirst$xLast".toInt()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println("/year2023/Day01.txt".asResourceFile().readLines().sumOf { line -> findNumber(line) })
    }
}
