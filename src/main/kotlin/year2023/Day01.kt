package year2023

import util.asResourceFile

object Day01 {
    private val digits = listOf("one", "two", "three", "four", "five", "six", "seven", "eight", "nine")

    private fun findNumber(st: String): Int {
        var x = st
        var notDone = true
        while (notDone) {
            var minIdx = -1
            var minPos = Int.MAX_VALUE
            digits.forEachIndexed { idx, s ->
                val pos = x.indexOf(s)
                if (pos in 0 until minPos) {
                    minPos = pos
                    minIdx = idx
                }
            }
            if (minIdx >= 0) x = x.replaceFirst(digits[minIdx], (1 + minIdx).toString()) else notDone = false
        }

        val y = x.filter { c -> c.isDigit() }
        val z = "${y.first()}${y.last()}".toInt()
        println("$st\t$x\t$y\t$z")
        return z
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println("/year2023/Day01.txt".asResourceFile().readLines().sumOf { line -> findNumber(line) })
    }
}
